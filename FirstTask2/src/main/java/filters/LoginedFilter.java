package filters;

import model.UserDataSet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String servletPath = request.getServletPath();

        //Получаем пользователя сессии
        UserDataSet uds = (UserDataSet) request.getSession().getAttribute("loginedUser");

        //Если страница стартовая
        if (servletPath.equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        } else {
            //Если пользователь еще не вошел
            if (uds == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            } else {
                //Проверка доступа
                if (uds.getRole().equals("admin") & !servletPath.equals("/adminListUsers")) {
                    response.sendRedirect(request.getContextPath() + "/adminListUsers");
                    return;
                } else if (uds.getRole().equals("user") &  !servletPath.equals("/userListUsers")) {
                    response.sendRedirect(request.getContextPath() + "/userListUsers");
                    return;
                }
                filterChain.doFilter(request, response);
            }
        }
    }
}
