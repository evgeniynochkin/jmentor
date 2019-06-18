package DAO;

import model.UserDataSet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import service.HibernateSessionFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(UserDataSet uds) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(uds);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(UserDataSet uds) {

    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public UserDataSet getUserByLogin(String fLogin) {
        EntityManager em = entityManagerFactory.
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Query query = session.createQuery("from users where login = :paramLogin");
//        query.setParameter("paramLogin", fLogin);
//        UserDataSet uds = (UserDataSet) query.getSingleResult();
//        session.close();
//        List<UserDataSet> users = findAll();
//        for (UserDataSet user : users) {
//            if (user.getLogin().equals(fLogin)) { uds = user; }
//        }
        return uds;
    }

    @Override
    public List<UserDataSet> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<UserDataSet> users = (List<UserDataSet>) session
                .createQuery("from UserDataSet", UserDataSet.class).list();
        transaction.commit();
        session.close();
        return users;
    }
}
