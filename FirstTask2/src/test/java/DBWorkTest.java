import exception.DBException;
import model.UserDataSet;
import service.UserService;
import org.junit.Before;
import org.junit.Test;
import service.UserServiceImpl;

public class DBWorkTest {

    UserService userService;

    @Before
    public void init() { userService = new UserServiceImpl(); }

    @Test
    public void addNewUserWhithoutName() throws DBException {
        try {
            UserDataSet uds = new UserDataSet();
            uds.setLogin("first");
            uds.setPassword("111");
            uds.setName("first");

            UserService usl = new UserServiceImpl();
            usl.addUser(uds);

        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
