import exception.DBException;
import org.junit.Before;
import org.junit.Test;
import service.UsersService;
import service.UsersServiceImpl;

import static org.junit.Assert.assertTrue;

public class DBWorkTest {

    UsersService usersService;

    @Before
    public void init() {
        usersService = new UsersServiceImpl();
    }

//    //создание пользователя без имени
//    @Test
//    public void addNewUserWhithoutName() throws DBException {
//        try {
//            long userId = dbService.addUserWithoutName("max1", "pas1");
//            System.out.println("Added user id: " + userId);
////            UsersDataSet user = dbService.getUser(userId);
////            UsersDataSet expected = new UsersDataSet("max1", "pas1");
//
////            assertTrue("Пользователь не создан", user != expected);
//        } catch (DBException e) {
//            e.printStackTrace();
//        }
//    }

//    //создание пользователя с имененм
//    @Test
//    public void addNewUserWhithName() {
//
//    }
//
//    //получение ID пользователя
//    @Test
//    public long getIDUser() {
//        return 0;
//    }
//
//    //получение логина по ID пользователя
//    @Test
//    public String getLoginUserToId() {
//        return null;
//    }
//
//    //удаление пользователя
//    @Test
//    public void deleteUser() {
//
//    }
//
//    //изменение имени пользователя
//    @Test
//    public void renameUserName() {
//
//    }
//
//    //изменение пароля пользоавтеля
//    @Test
//    public void renameUserPassword() {
//
//    }
}
