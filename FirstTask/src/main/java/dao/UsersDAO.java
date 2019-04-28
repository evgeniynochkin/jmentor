package dao;

import dataset.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Evgeniy Nochkin
 * @since 1.1
 */

public class UsersDAO {

    private Session session;

    //конструктор
    public UsersDAO(Session session) { this.session = session; }

    //создать пользователя с именем
    public long insertUser(String login, String password, String name) {
        return (Long) session.save(new UsersDataSet(login, password, name));
    }

    //создать пользователя без имени
    public long insertUser(String login, String password) {
        return (Long) session.save(new UsersDataSet(login, password));
    }

    //удалить пользователя по ID
    public void del(long id) throws HibernateException {
        session.delete(id);
    }

    //получить пользователя по ID
    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    //получить ID пользователя по логину
    public long getUserId(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult()).getId();
    }

    //изменить имя пользователя

    //изменить пароль пользователя
}
