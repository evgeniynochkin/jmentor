package service;

import model.UserDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import properties.PropertyDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMakeCon {
    private static DBMakeCon instance;

    public Connection jdbcConnection;
    public static PropertyDB propertyDB = new PropertyDB();
    public static SessionFactory sessionFactory;

    private static Configuration configuration = new Configuration();

    private DBMakeCon() { }

    public static synchronized DBMakeCon getInstance() {
        if (instance == null) {
            instance = new DBMakeCon();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                try {
                    Class.forName(propertyDB.DB_DRIVER);
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
                jdbcConnection = DriverManager.getConnection(propertyDB.DB_URL, propertyDB.DB_USER, propertyDB.DB_PASSWORD);
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
        configuration.setProperty("hibernate.dialect", propertyDB.HIBERNATE_DIALECT);
        configuration.setProperty("hibernate.connection.driver_class", propertyDB.DB_DRIVER);
        configuration.setProperty("hibernate.connection.url", propertyDB.DB_URL);
        configuration.setProperty("hibernate.connection.username", propertyDB.DB_USER);
        configuration.setProperty("hibernate.connection.password", propertyDB.DB_PASSWORD);
        configuration.setProperty("hibernate.show_sql", propertyDB.hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", propertyDB.hibernate_hbm2ddl_auto);

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
