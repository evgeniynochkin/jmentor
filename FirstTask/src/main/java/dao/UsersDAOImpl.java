package dao;

import model.UsersDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.HibernateSessionFactory;

import java.util.List;

/**
 * @author Evgeniy Nochkin
 * @since 1.1
 */

public class UsersDAOImpl implements UsersDAO {

    @Override
    public void addUser(UsersDataSet uds) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(uds);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(UsersDataSet uds) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(uds);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUser(int id) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UsersDataSet uds = (UsersDataSet) session.load(UsersDataSet.class, new Integer(id));

        if(uds!=null) {
            session.delete(uds);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public UsersDataSet getUserById(int id) throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        UsersDataSet uds = (UsersDataSet) session.load(UsersDataSet.class, new Integer(id));
        session.close();
        return uds;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UsersDataSet> listUsers() throws HibernateException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<UsersDataSet> usersList = session.createQuery("from USERS").list();
        session.close();
        return usersList;
    }
}
