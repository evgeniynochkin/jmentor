package security;

import service.UrlPatternUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public class SecurityUtils {

    //Проверка
    public static boolean isSecurityPage(HttpServletRequest request) {

        String urlPattern = UrlPatternUtils.getUrlPattern(request);

        Set<String> roles = SecurityConfig.getAllAppRules();

        for (String role : roles) {
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    //Проверка доступа
    public static boolean hasPermission(HttpServletRequest request) {

        String urlPattern = UrlPatternUtils.getUrlPattern(request);

        Set<String> allRoles = SecurityConfig.getAllAppRules();

        for (String role : allRoles) {
            if (!request.isUserInRole(role)) {
                continue;
            }
            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }
}
