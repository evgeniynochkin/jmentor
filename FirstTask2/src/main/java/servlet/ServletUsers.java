package servlet;


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
import java.util.List;

@WebServlet(name = "ServletUsers", urlPatterns = "/ListUsers")
public class ServletUsers extends HttpServlet {

    private UserService usi = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUsers(request, response);
                    break;
            }
        } catch (DBException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws DBException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        UserDataSet uds = new UserDataSet();
        uds.setLogin(login);
        uds.setPassword(password);
        uds.setName(name);

        usi.addUser(uds);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws DBException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        usi.removeUser(id);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws DBException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        UserDataSet existingUser = usi.getUserById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserForm.jsp");
        request.setAttribute("User", existingUser);
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws DBException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        UserDataSet uds = new UserDataSet();
        uds.setLogin(login);
        uds.setPassword(password);
        uds.setName(name);

        usi.updateUser(uds, id);
        response.sendRedirect("list");
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws DBException, IOException, ServletException {
        List<UserDataSet> listUsers = usi.findAllUsers();
        request.setAttribute("listUsers", listUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListUsers.jsp");
        dispatcher.forward(request, response);
    }
}
