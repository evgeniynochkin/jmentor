package service;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import exception.DBException;
import model.UserDataSet;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    public UserServiceImpl() {}

    public void addUser(UserDataSet uds) throws DBException {
        userDAO.addUser(uds);
    }

    public void updateUser(UserDataSet uds) throws DBException {

    }

    public void removeUser(int id) throws DBException {

    }

    public UserDataSet getUserById(int id) throws DBException {
        return null;
    }
}
