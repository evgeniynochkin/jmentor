package filters;

import exception.DBException;
import model.UserDataSet;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebFilter("/adminListUsers")
public class AdminFilter implements Filter {

    private UserService usi = new UserServiceImpl();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        UserDataSet uds;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //Получаем пользователя сессии
        uds = (UserDataSet) request.getSession().getAttribute("loginedUser");

        //Если пользователь еще не вошел
        if (uds == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        //Проверка доступа
        if (!uds.getRole().equals("admin")) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/accessDenied.jsp");

            dispatcher.forward(request, response);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
