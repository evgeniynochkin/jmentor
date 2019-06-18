import exception.DBException;
import model.UserDataSet;
import property.DBProperty;
import service.UserService;
import service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    static final String USER = "postgres";
    static final String PWD = "1111";

    public static void main(String[] args) throws DBException {

        UserService userService = new UserServiceImpl();
        UserDataSet uds = new UserDataSet();

        uds.setName("name1");
        uds.setLogin("login1");
        uds.setPassword("pass1");
        userService.addUser(uds);

        uds.setName("name2");
        uds.setLogin("login2");
        uds.setPassword("pass2");
        userService.addUser(uds);

        uds.setName("name3");
        uds.setLogin("login3");
        uds.setPassword("pass3");
        userService.addUser(uds);

        System.out.println(userService.getUserByLogin("login2"));

        //Очистка БД
        Connection con = null;
        Statement statement = null;
        try {
            Class.forName(DBProperty.HIBERNATE_DRIVER);

            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(DBProperty.HIBERNATE_URL, USER,PWD);

            System.out.println("Dropping Table..");
            statement = con.createStatement();
            String sql = "drop table users ";
            statement.executeUpdate(sql);
            System.out.println("Table Dropped.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                System.out.println("Closing Connection");
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException sqlEx) {
                System.out.println(sqlEx.getMessage());
            }
        }
        System.out.println("Ending Program..");
    }
}
