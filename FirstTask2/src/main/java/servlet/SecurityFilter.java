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

        HttpServletRequest wrapRequest = request;

        //Если пользователь уже вошел
        if (uds != null) {

            String userName = uds.getName();
            String userRole = uds.getRole();

            wrapRequest = new UserRoleRequestWrapper(userName, userRole, request);
        }

        //
        if (SecurityUtils.isSecurityPage(request)) {

            if (uds == null) {
                response.sendRedirect(wrapRequest.getContextPath() + "/login");
                return;
            }

            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/webapp/accessDeniedView.jsp");

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
