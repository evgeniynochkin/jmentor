package service;

import dao.UsersDAOImpl;
import exception.DBException;
import model.UsersDataSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import property.DBproperty;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersDAOImpl usersDAOImpl;

    private final SessionFactory sessionFactory;

    public UsersServiceImpl() {
        Configuration configuration = new DBproperty().H2Configuration();
        sessionFactory = createSessionFactory(configuration);
    }

    @Override
    public void addUser(UsersDataSet uds) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            usersDAOImpl = new UsersDAOImpl(session);
            this.usersDAOImpl.addUser(uds);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    @Override
    public void updateUser(UsersDataSet uds) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            usersDAOImpl = new UsersDAOImpl(session);
            this.usersDAOImpl.updateUser(uds);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    @Override
    public void removeUser(int id) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            usersDAOImpl = new UsersDAOImpl(session);
            this.usersDAOImpl.removeUser(id);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    @Override
    public UsersDataSet getUserById(int id) throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            usersDAOImpl = new UsersDAOImpl(session);
            UsersDataSet uds = this.usersDAOImpl.getUserById(id);
            transaction.commit();
            session.close();
            return uds;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    @Override
    public List<UsersDataSet> listUsers() throws DBException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            usersDAOImpl = new UsersDAOImpl(session);
            List<UsersDataSet> uds = this.usersDAOImpl.listUsers();
            transaction.commit();
            session.close();
            return uds;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
