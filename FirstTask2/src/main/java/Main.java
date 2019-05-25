import exception.DBException;
import model.UserDataSet;
import service.UserService;
import service.UserServiceImpl;

public class Main {
    public static void main(String[] args) throws DBException {

        UserService userService = new UserServiceImpl();
        UserDataSet uds = new UserDataSet();
        uds.setName("fff1");
        uds.setLogin("FFF1");
        uds.setPassword("pass1");
        userService.addUser(uds);
    }
}
