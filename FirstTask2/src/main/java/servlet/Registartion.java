package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class Registartion extends Dispatcher {

    public String getServletInfo() {
        return "Registration servlet";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sct = getServletContext();
        if (request.getParameter("login") != null) {
            this.forward("/CheckUser", request, response);
        } else {
            this.forward("/registration.jsp", request, response);
        }
    }
}
