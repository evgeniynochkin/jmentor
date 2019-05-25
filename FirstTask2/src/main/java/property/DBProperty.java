package property;

import org.hibernate.cfg.Configuration;

public class DBProperty {
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "update";

    Configuration configuration = new Configuration();

    public Configuration H2Configuratio() {
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/ft");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "1111");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }
}
