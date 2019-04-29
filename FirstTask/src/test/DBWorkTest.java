import dataset.UsersDataSet;
import exception.DBException;
import org.junit.Before;
import org.junit.Test;
import service.DBService;

import static org.junit.Assert.assertTrue;

public class DBWorkTest {

    DBService dbService;

    @Before
    public void init() {
        dbService = new DBService();
    }

    //создание пользователя без имени
    @Test
    public void addNewUserWhithoutName() throws DBException {
        long userId = dbService.addUserWithoutName("max1", "pas1");
        UsersDataSet user = dbService.getUser(userId);
        UsersDataSet expected = new UsersDataSet("max1", "pas1");

        assertTrue("Пользователь не создан", user != expected);
    }

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
