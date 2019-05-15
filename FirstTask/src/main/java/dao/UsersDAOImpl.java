package dao;

import model.UsersDataSet;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Evgeniy Nochkin
 * @since 1.1
 */

//@Repository
public class UsersDAOImpl implements UsersDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void addUser(UsersDataSet uds) {
        session.persist(uds);
    }

    @Override
    public void updateUser(UsersDataSet uds) {
        session.update(uds);
    }

    @Override
    public void removeUser(int id) {
        UsersDataSet uds = (UsersDataSet) session.load(UsersDataSet.class, new Integer(id));

        if(uds!=null) {
            session.delete(uds);
        }
    }

    @Override
    public UsersDataSet getUserById(int id) {
        UsersDataSet uds = (UsersDataSet) session.load(UsersDataSet.class, new Integer(id));
        return uds;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UsersDataSet> listUsers() {
        List<UsersDataSet> usersList = session.createQuery("from USERS").list();
        return usersList;
    }


//    //конструктор
//    public UsersDAOImpl(Session session) { this.session = session; }
//
//    //создать пользователя с именем
//    public long insertUser(String login, String password, String name) {
//        return (Long) session.save(new UsersDataSet(login, password, name));
//    }
//
//    //создать пользователя без имени
//    public long insertUser(String login, String password) {
//        return (Long) session.save(new UsersDataSet(login, password));
//    }
//
//    //удалить пользователя по ID
//    public void del(long id) throws HibernateException {
//        session.delete(id);
//    }
//
//    //получить пользователя по ID
//    public UsersDataSet get(long id) throws HibernateException {
//        return (UsersDataSet) session.get(UsersDataSet.class, id);
//    }
//
//    //получить ID пользователя по логину
//    public long getUserId(String login) throws HibernateException {
//        Criteria criteria = session.createCriteria(UsersDataSet.class);
//        return ((UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult()).getId();
//    }

    //изменить имя пользователя

    //изменить пароль пользователя
}
