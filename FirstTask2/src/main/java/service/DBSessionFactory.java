package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSessionFactory {

    public final static String JDBC_URL = "jdbc:postgresql://localhost:5432/ft";
    public final static String JDBC_USER = "postgres";
    public final static String JDBC_PASSWORD = "1111";

    public Connection jdbcConnection;

    public Connection connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Connection");
        }
        return jdbcConnection;
    }

    public void disconnect(Connection jdbcCon) throws SQLException {
        if (jdbcCon != null && !jdbcCon.isClosed()) {
            jdbcCon.close();
        }
    }
}
