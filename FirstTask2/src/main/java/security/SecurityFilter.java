package security;

import DAO.UserDAO;
import model.UserDataSet;
import service.AppUtils;
import service.UserRoleRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SecurityFilter implements Filter {

    private UserDAO userDAO;
    private UserDataSet uds;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String servletPath = request.getServletPath();

        try {
           uds = userDAO.getUserByLogin(request.getSession().toString());
        } catch (SQLException e) {
            throw new ServletException(e);
        }

        if (servletPath.equals("/start")) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpServletRequest wrapRequest = request;

        if (uds != null) {

            String userName = uds.getName();
            String userRole = uds.getRole();

            wrapRequest = new UserRoleRequestWrapper(userName, userRole, request);
        }

        if (SecurityUtils.isSecurityPage(request)) {

            if (uds == null) {

                String requestUri = request.getRequestURI();

                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

                response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }

            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/webapp/accessDeniedView.jsp");

                dispatcher.forward(request, response);
                return;
            }
        }

        filterChain.doFilter(wrapRequest, response);
    }

    @Override
    public void destroy() {

    }
}
