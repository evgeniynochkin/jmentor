import exception.DBException;
import model.UserDataSet;
import service.UserService;
import service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) throws DBException {

        UserService userService = new UserServiceImpl();
        UserDataSet uds = new UserDataSet();
//        uds.setName("name1");
//        uds.setLogin("login1");
//        uds.setPassword("pass1");
//        userService.addUser(uds);
        System.out.println(userService.getUserByLogin("name1"));
    }
}
