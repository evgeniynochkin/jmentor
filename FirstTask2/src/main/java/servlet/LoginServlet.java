package servlet;

import exception.DBException;
import model.UserDataSet;
import service.AppUtils;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet({"/","/login"})
public class LoginServlet extends HttpServlet {

    public UserDataSet uds;

    public LoginServlet() { super(); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Start.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String userLogin = request.getParameter("userLogin");
        String password = request.getParameter("password");
        try {
            uds = new UserServiceImpl().getUserByLogin(userLogin);

            if (uds.getLogin() == null || !uds.getPassword().equals(password)) {
                String errorMessage = "Неверное имя пользователя или пароль";
                request.setAttribute("errorMessage", errorMessage);

                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Start.jsp");
                dispatcher.forward(request, response);
                return;
            }
        } catch (DBException | SQLException e) {
            throw new ServletException(e);
        }

        AppUtils.storeLoginedUser(request.getSession(), uds);

        int redirectId = -1;
        try {
            redirectId = Integer.parseInt(request.getParameter("redirectId"));
        } catch (Exception e) {
            throw new ServletException(e);
        }

        String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
        if (requestUri != null) {
            response.sendRedirect(request.getContextPath() + "/userInfo");
        }
    }
}
