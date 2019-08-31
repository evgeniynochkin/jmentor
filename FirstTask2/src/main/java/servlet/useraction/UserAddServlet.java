package servlet.useraction;

import exception.DBException;
import model.UserDataSet;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/useraction/insert")
public class UserAddServlet extends HttpServlet {

    private UserService usi = new UserServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            insertUser(request, response);
        } catch (DBException | SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/UserForm.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new ServletException(e);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws DBException, IOException, SQLException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        UserDataSet uds = new UserDataSet();
        uds.setLogin(login);
        uds.setPassword(password);
        uds.setName(name);

        usi.addUser(uds);
//        response.sendRedirect(String.format("%s%s", request.getServletPath(), "/hello"));
        response.sendRedirect("http://localhost:80/FirstTask2_war/hello");
    }
}
