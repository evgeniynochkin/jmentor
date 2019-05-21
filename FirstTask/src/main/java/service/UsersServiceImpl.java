package service;

import dao.UsersDAOImpl;
import exception.DBException;
import model.UsersDataSet;
import org.hibernate.HibernateException;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersDAOImpl usersDAOImpl;

    public UsersServiceImpl() {
        this.usersDAOImpl = new UsersDAOImpl();
    }

    @Override
    public void addUser(UsersDataSet uds) throws DBException {
        try {
            this.usersDAOImpl.addUser(uds);
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    @Override
    public void updateUser(UsersDataSet uds) throws DBException {
        try {
            this.usersDAOImpl.updateUser(uds);
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    @Override
    public void removeUser(int id) throws DBException {
        try {
            this.usersDAOImpl.removeUser(id);
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    @Override
    public UsersDataSet getUserById(int id) throws DBException {
        try {
            UsersDataSet uds = this.usersDAOImpl.getUserById(id);
            return uds;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }

    @Override
    public List<UsersDataSet> listUsers() throws DBException {
        try {
            List<UsersDataSet> uds = this.usersDAOImpl.listUsers();
            return uds;
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }
}
