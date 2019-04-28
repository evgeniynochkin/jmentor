import dataset.UsersDataSet;
import exception.DBException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import service.DBService;

import static org.junit.Assert.assertTrue;

public class DBWorkTest {

    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "create";

    Configuration configuration = getH2Configuration();
    private final SessionFactory sessionFactory = createSessionFactory(configuration);

    private Configuration getH2Configuration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UsersDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
        configuration.setProperty("hibernate.connection.username", "tully");
        configuration.setProperty("hibernate.connection.password", "tully");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    DBService dbService = new DBService();

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
