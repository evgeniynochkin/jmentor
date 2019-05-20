package dao;

import model.UsersDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * @author Evgeniy Nochkin
 * @since 1.1
 */

public class UsersDAOImpl implements UsersDAO {

    private Session session;

    public UsersDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public long addUser(UsersDataSet uds) throws HibernateException {
        return (Long) session.save(uds);
    }

    @Override
    public void updateUser(UsersDataSet uds) throws HibernateException {
        session.update(uds);
    }

    @Override
    public void removeUser(int id) throws HibernateException {
        UsersDataSet uds = (UsersDataSet) session.load(UsersDataSet.class, new Integer(id));

        if(uds!=null) {
            session.delete(uds);
        }
    }

    @Override
    public UsersDataSet getUserById(int id) throws HibernateException {
        UsersDataSet uds = (UsersDataSet) session.load(UsersDataSet.class, new Integer(id));
        return uds;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UsersDataSet> listUsers() throws HibernateException {
        List<UsersDataSet> usersList = session.createQuery("from USERS").list();
        return usersList;
    }
}
