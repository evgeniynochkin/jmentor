package property;

import model.UserDataSet;
import org.hibernate.cfg.Configuration;

public class DBProperty {
    public static final String HIBERNATE_DIALECT = "org.hibernate.dialect.PostgreSQL10Dialect";
    public static final String HIBERNATE_DRIVER = "org.postgresql.Driver";
    public static final String HIBERNATE_URL = "jdbc:postgresql://localhost:5432/ft";
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "update";

    Configuration configuration = new Configuration();

    public Configuration H2Configuratio() {
        configuration.setProperty("hibernate.dialect", HIBERNATE_DIALECT);
        configuration.setProperty("hibernate.connection.driver_class", HIBERNATE_DRIVER);
        configuration.setProperty("hibernate.connection.url", HIBERNATE_URL);
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "1111");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);

        configuration.addAnnotatedClass(UserDataSet.class);
        return configuration;
    }
}
