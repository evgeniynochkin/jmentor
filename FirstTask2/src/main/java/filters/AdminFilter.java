package filters;

import exception.DBException;
import model.UserDataSet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/adminListUsers")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        UserDataSet uds;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //Получаем пользователя сессии
        uds = (UserDataSet) request.getSession().getAttribute("loginedUser");

        //Проверка доступа
        if (uds.getRole().equals("admin")) {
            filterChain.doFilter(request, response);
            return;
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
    }
}
