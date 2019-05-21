package DAO;

import model.UserDataSet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.HibernateSessionFactoryUtil;

public class UserDAOImpl implements UserDAO {

    public void addUser(UserDataSet uds) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(uds);
        transaction.commit();
        session.close();
    }

    public void updateUser(UserDataSet uds) {

    }

    public void removeUser(int id) {

    }

    public UserDataSet getUserById(int id) {
        return null;
    }
}
