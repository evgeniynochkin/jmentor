package service;

import model.UserDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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

    static String driver;
    static String url;
    static String user;
    static String password;

    static String hibDialect;
    static String hibShowSQL;
    static String hibHBM2DLLAuto;

    public static String useORM;

    public static Connection jdbcConnection;
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
        getHibernateProperties();

        configuration.setProperty("hibernate.dialect", hibDialect);
        configuration.setProperty("hibernate.connection.driver_class", driver);
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", user);
        configuration.setProperty("hibernate.connection.password", password);
        configuration.setProperty("hibernate.show_sql", hibShowSQL);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibHBM2DLLAuto);

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
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

            fis = new FileInputStream(rootPath + "config.properties");
            properties.load(fis);

            useORM = properties.getProperty("use.orm");

            driver = properties.getProperty("db.driver");
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");

        } catch (IOException e) {
            System.err.println("Файл свойств отсутсвует");
        }
    }

    static void getHibernateProperties() {
        hibDialect = properties.getProperty("hib.dialect");
        hibShowSQL = properties.getProperty("hib.show_sql");
        hibHBM2DLLAuto = properties.getProperty("hib.hbm2dllauto");
    }
}
