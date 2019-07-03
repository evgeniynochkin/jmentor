package servlet;

import exception.DBException;
import model.UserDataSet;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class CheckUser extends Dispatcher {

    public String getServletInfo() {
        return "Registration servlet";
    }

    public void servlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DBException {
        UserService usv = new UserServiceImpl();
        UserDataSet uds = usv.getUserByLogin(request.getParameter("login"));
        if (uds == null) {
            this.forward("/registration.html", request, response);
        } else {
            if (!uds.getPassword().equals(request.getParameter("password"))) {
                this.forward("/regisration.html", request, response);
            } else {
                this.forward("/successLogin", request, response);
            }
        }
    }
}
