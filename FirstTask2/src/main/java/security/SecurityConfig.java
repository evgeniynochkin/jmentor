package security;

import java.util.*;

public class SecurityConfig {

    public static final String ROLE_USER = "user";
    public static final String ROLE_ADMIN = "admin";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        initial();
    }

    private static void initial() {

        List<String> urlPattern1 = new ArrayList<String>();

        urlPattern1.add("/userInfo");
        urlPattern1.add("/userListUser");

        mapConfig.put(ROLE_USER, urlPattern1);

        List<String> urlPattern2 = new ArrayList<String>();

        urlPattern2.add("/userInfo");
        urlPattern2.add("/userListUser");
        urlPattern2.add("/adminListUsers");

        mapConfig.put(ROLE_ADMIN, urlPattern2);
    }

    public static Set<String> getAllAppRules() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}
