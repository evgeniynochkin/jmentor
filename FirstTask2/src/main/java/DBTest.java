import exception.DBException;
import model.UserDataSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import property.DBProperty;
import service.UserService;
import service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBTest extends Assert {
    static final String USER = "postgres";
    static final String PWD = "1111";
    UserService usi = new UserServiceImpl();
    UserDataSet uds = new UserDataSet();

//    @Before
//    public void beginTest() throws DBException {
//        uds.setLogin("First");
//        uds.setPassword("111");
//        uds.setName("Mr_One");
//        usi.addUser(uds);
//
//        uds.setLogin("Second");
//        uds.setPassword("222");
//        uds.setName("Mr_Two");
//        usi.addUser(uds);
//
//        uds.setLogin("Third");
//        uds.setPassword("333");
//        uds.setName("Mr_Three");
//        usi.addUser(uds);
//    }

//    @After
//    public void endText() {
//        Connection con = null;
//        Statement statement = null;
//        try {
//            Class.forName(DBProperty.HIBERNATE_DRIVER);
//
//            System.out.println("Connecting to database...");
//            con = DriverManager.getConnection(DBProperty.HIBERNATE_URL, USER,PWD);
//
//            System.out.println("Dropping Table..");
//            statement = con.createStatement();
//            String sql = "drop table users ";
//            statement.executeUpdate(sql);
//            System.out.println("Table Dropped.");
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                System.out.println("Closing Connection");
//                if (statement != null)
//                    statement.close();
//            } catch (SQLException e) {
//            }
//            try {
//                if (con != null)
//                    con.close();
//            } catch (SQLException sqlEx) {
//                System.out.println(sqlEx.getMessage());
//            }
//        }
//        System.out.println("Ending Program..");
//    }

    @Test
    public void runTest() throws DBException {
        List<UserDataSet> listUsers = usi.findAllUsers();
        for (UserDataSet lu : listUsers) {
            System.out.println(lu);
        }
    }
}
