package filters;

import model.UserDataSet;
import service.AppUtils;

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

        String servletPath = request.getServletPath();

        //Получаем пользователя сессии
        uds = AppUtils.getLoginedUser(request.getSession());

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
