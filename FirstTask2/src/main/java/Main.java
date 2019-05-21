import exception.DBException;
import model.UserDataSet;
import service.UserService;
import service.UserServiceImpl;

public class Main {
    public static void main(String[] args) throws DBException {

        UserService userService = new UserServiceImpl();
        UserDataSet uds = new UserDataSet();
        uds.setName("fff2");
        uds.setLogin("FFF2");
        uds.setPassword("pass2");
        userService.addUser(uds);
    }
}
