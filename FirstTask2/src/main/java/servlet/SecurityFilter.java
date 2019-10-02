package servlet;

import model.UserDataSet;
import security.SecurityUtils;
import service.AppUtils;
import service.UserRoleRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/*")
public class SecurityFilter implements Filter {

    private UserDataSet uds;

    public SecurityFilter() { }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        String servletPath = request.getServletPath();
//
//        uds = AppUtils.getLoginedUser(request.getSession());

//        if (servletPath.equals("/login")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        HttpServletRequest wrapRequest = request;
//
//        if (uds != null) {
//
//            String userName = uds.getName();
//            String userRole = uds.getRole();
//
//            wrapRequest = new UserRoleRequestWrapper(userName, userRole, request);
//        }
//
//        if (SecurityUtils.isSecurityPage(request)) {
//
//            if (uds == null) {
//
//                String requestUri = request.getRequestURI();
//
//                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);
//
//                response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
//                return;
//            }
//
//            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
//            if (!hasPermission) {
//                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/webapp/accessDeniedView.jsp");
//
//                dispatcher.forward(request, response);
//                return;
//            }
//        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() { }
}
