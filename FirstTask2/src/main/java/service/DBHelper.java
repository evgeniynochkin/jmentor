package service;

import model.UserDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static DBHelper instance;

    public final static String DB_URL = "jdbc:postgresql://localhost:5432/ft";
    public final static String DB_USER = "postgres";
    public final static String DB_PASSWORD = "1111";
    public Connection jdbcConnection;

    public static final String HIBERNATE_DIALECT = "org.hibernate.dialect.PostgreSQL10Dialect";
    public static final String HIBERNATE_DRIVER = "org.postgresql.Driver";
    public static final String HIBERNATE_URL = "jdbc:postgresql://localhost:5432/ft";
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "update";
    private static SessionFactory sessionFactory;
    private static Configuration configuration = new Configuration();

    private DBHelper() { }

    public static synchronized DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
                jdbcConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("Connection");
            }
            return jdbcConnection;
    }

    public void disconnect(Connection jdbcCon) throws SQLException {
        if (jdbcCon != null && !jdbcCon.isClosed()) {
            jdbcCon.close();
        }
    }

    public static SessionFactory getConfiguration() {
        configuration.setProperty("hibernate.dialect", HIBERNATE_DIALECT);
        configuration.setProperty("hibernate.connection.driver_class", HIBERNATE_DRIVER);
        configuration.setProperty("hibernate.connection.url", DB_URL);
        configuration.setProperty("hibernate.connection.username", DB_USER);
        configuration.setProperty("hibernate.connection.password", DB_PASSWORD);
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);

        if (sessionFactory == null) {
            try {
                configuration.addAnnotatedClass(UserDataSet.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
                builder.applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        return sessionFactory;
    }
}
