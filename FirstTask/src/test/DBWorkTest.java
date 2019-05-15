import exception.DBException;
import model.UsersDataSet;
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

    //создание пользователя без имени
    @Test
    public void addNewUserWhithoutName() throws DBException {
        try {
            UsersDataSet uds = new UsersDataSet();
            uds.setId(1);
            uds.setLogin("first");
            uds.setPassword("111");
            uds.setName("first");

            UsersServiceImpl usl = new UsersServiceImpl();
            usl.addUser(uds);

        } catch (DBException e) {
            e.printStackTrace();
        }
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
