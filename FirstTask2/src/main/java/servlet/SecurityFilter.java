package servlet;

import model.UserDataSet;
import security.SecurityUtils;
import service.AppUtils;
import service.UserRoleRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class SecurityFilter implements Filter {

    public SecurityFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        UserDataSet uds;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String servletPath = request.getServletPath();

        //Получаем пользователя сессии
        uds = AppUtils.getLoginedUser(request.getSession());

        //Если страница входа
        if (servletPath.equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        //Если пользователь уже вошел
        HttpServletRequest wrapRequest = request;
        if (uds != null) {

            String userName = uds.getName();
            String userRole = uds.getRole();

            wrapRequest = new UserRoleRequestWrapper(userName, userRole, request);
        }

        //Проверка страниц с ограниченным доступом
        if (SecurityUtils.isSecurityPage(request)) {

            //Перенаправление на страницу входа, если не вошел
            if (uds == null) {
                response.sendRedirect(wrapRequest.getContextPath() + "/login");
                return;
            }

            //Проверка доступа пользователя
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/accessDenied.jsp");

                dispatcher.forward(request, response);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
