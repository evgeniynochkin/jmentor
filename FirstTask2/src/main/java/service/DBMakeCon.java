package service;

import model.UserDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import properties.PropertyDB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBMakeCon {
    private static DBMakeCon instance;

    static FileInputStream fis;
    static Properties properties = new Properties();

    public static String driver;
    public static String url;
    public static String user;
    public static String password;

    public static Connection jdbcConnection;
    public static PropertyDB propertyDB = new PropertyDB();
    public static SessionFactory sessionFactory;

    private static Configuration configuration = new Configuration();

    private DBMakeCon() { }

    public static synchronized DBMakeCon getInstance() {
        if (instance == null) {
            instance = new DBMakeCon();
            getProperties();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException {

            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                getProperties();
                try {
//                    getProperties();
//                    Class.forName(propertyDB.DB_DRIVER);
                    Class.forName(driver);
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
                jdbcConnection = DriverManager.getConnection(url, user, password);
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
        configuration.setProperty("hibernate.connection.driver_class", driver);
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", user);
        configuration.setProperty("hibernate.connection.password", password);
        configuration.setProperty("hibernate.show_sql", propertyDB.HIBERNATE_SHOW_SQL);
        configuration.setProperty("hibernate.hbm2ddl.auto", propertyDB.HIBERNATE_HBM_2_DDL_AUTO);

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

    public static void getProperties() {
        try {
//            fis = new FileInputStream("src/main/resources/config.properties");
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

            fis = new FileInputStream(rootPath + "config.properties");
            properties.load(fis);

            driver = properties.getProperty("db.driver");
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
        } catch (IOException e) {
            System.err.println("Файл свойств отсутсвует");
        }
    }
}
