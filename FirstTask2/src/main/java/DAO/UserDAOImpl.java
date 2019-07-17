package DAO;

import model.UserDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import service.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    Session session;

    public Session getSession() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return session;
    }

    public void closeSession(Session session) {
        session.close();
    }

    @Override
    public void addUser(UserDataSet uds) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(uds);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(UserDataSet uds, Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update UserDataSet set login = :paramLogin" +
                ", password = :paramPassword" +
                ", name = :paramName" +
                " where id = :paramId");
        query.setParameter("paramLogin", uds.getLogin());
        query.setParameter("paramPassword", uds.getPassword());
        query.setParameter("paramName", uds.getName());
        query.setParameter("paramId", id);
        int result = query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUser(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete UserDataSet where id = :paramId");
        query.setParameter("paramId", id);
        int result = query.executeUpdate();
        transaction.commit();
        session.close();
        System.out.println(result);
    }

    @Override
    public UserDataSet getUserByLogin(String fLogin) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from UserDataSet where login = :paramLogin", UserDataSet.class);
        query.setParameter("paramLogin", fLogin);
        UserDataSet uds = (UserDataSet) query.uniqueResult();
        session.close();
        return uds;
    }

    @Override
    public UserDataSet getUserById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from UserDataSet where id = :paramId", UserDataSet.class);
        query.setParameter("paramId", id);
        UserDataSet uds = (UserDataSet) query.uniqueResult();
        session.close();
        return uds;
    }

    @Override
    public List<UserDataSet> findAll() {
        session = getSession();
        Transaction transaction = session.beginTransaction();
//        List<UserDataSet> users = (List<UserDataSet>) session
//                .createQuery("from UserDataSet", UserDataSet.class).list();
        Query query = session.createQuery("FROM UserDataSet");
        List<UserDataSet> users = query.list();
        transaction.commit();
        closeSession(session);
        return users;
    }
}
