package DAO;

import model.UserDataSet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.DBMakeCon;

import java.sql.*;
import java.util.List;

public class UserDAOHibernateImpl implements UserDAO {
    private DBMakeCon dbMakeCon;
    private Session session;

    public void openSession() { this.session = dbMakeCon.getConfiguration().openSession(); }

    public void closeSession() {
        this.session.close();
    }

    @Override
    public void addUser(UserDataSet uds) throws SQLException {

        openSession();
        Transaction transaction = session.beginTransaction();
        session.save(uds);
        transaction.commit();
        closeSession();
    }

    @Override
    public void updateUser(UserDataSet uds, Integer id) throws SQLException {

        openSession();
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
        closeSession();
    }

    @Override
    public void removeUser(int id) throws SQLException {

        openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete UserDataSet where id = :paramId");
        query.setParameter("paramId", id);
        int result = query.executeUpdate();
        transaction.commit();
        closeSession();
        System.out.println(result);
    }

    @Override
    public UserDataSet getUserByLogin(String fLogin) throws SQLException {

        openSession();
        Query query = session.createQuery("from UserDataSet where login = :paramLogin", UserDataSet.class);
        query.setParameter("paramLogin", fLogin);
        UserDataSet uds = (UserDataSet) query.uniqueResult();
        closeSession();
        return uds;
    }

    @Override
    public UserDataSet getUserById(Integer id) throws SQLException {

        openSession();
        Query query = session.createQuery("from UserDataSet where id = :paramId", UserDataSet.class);
        query.setParameter("paramId", id);
        UserDataSet uds = (UserDataSet) query.uniqueResult();
        closeSession();
        return uds;
    }

    @Override
    public List<UserDataSet> findAll() throws SQLException {

        openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM UserDataSet");
        List<UserDataSet> users = query.list();
        transaction.commit();
        closeSession();
        return users;
    }
}
