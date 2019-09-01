package servlet.useraction;

import exception.DBException;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/useraction/delete")
public class UserDeleteServlet extends HttpServlet {

    private UserService usi = new UserServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            deleteUser(request, response);
        } catch (DBException | SQLException e) {
            throw new ServletException(e);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws DBException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        usi.removeUser(id);
        response.sendRedirect("http://localhost:80/FirstTask2_war/hello");
    }
}
