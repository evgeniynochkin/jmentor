package filters;

import model.UserDataSet;
import service.AppUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class RegisterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {    }

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

        //Если пользователь еще не вошел
        if (uds == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {    }
}
