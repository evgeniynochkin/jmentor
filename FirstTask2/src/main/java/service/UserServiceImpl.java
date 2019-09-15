package service;

import DAO.UserDAO;
import exception.DBException;
import factories.UserDAOHibernateFactory;
import factories.UserDAOJDBCFactory;
import model.UserDataSet;
import properties.PropertyDB;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private PropertyDB propertyDB = new PropertyDB();

    private UserDAO userDAO;

    public UserServiceImpl() {
        if (propertyDB.useHibernate) {
            userDAO = new UserDAOHibernateFactory().workDAO();
        } else {
            userDAO = new UserDAOJDBCFactory().workDAO();
        }
    }

    @Override
    public String addUser(UserDataSet uds) throws DBException, SQLException {
        List<UserDataSet> lUsers = findAllUsers();
        for (UserDataSet user : lUsers) {
            if (user.getName().equals(uds.getName())) {
                return "Такой пользователь уже существует";
            }
        }
        userDAO.addUser(uds);
        return "Пользователь добавлен";
    }

    @Override
    public void updateUser(UserDataSet uds, Integer id) throws DBException, SQLException {
        userDAO.updateUser(uds, id);
    }

    @Override
    public void removeUser(int id) throws DBException, SQLException {
        userDAO.removeUser(id);
    }

    @Override
    public UserDataSet getUserByLogin(String login) throws DBException, SQLException {
        UserDataSet tempUser =  userDAO.getUserByLogin(login);
        if (tempUser != null) {
            return tempUser;
        } else {
            System.out.println("Пользователя с логином " + login + " не существует!");
            return null;
        }
    }

    @Override
    public UserDataSet getUserById(Integer id) throws DBException, SQLException {
        UserDataSet tempUser =  userDAO.getUserById(id);
        if (tempUser != null) {
            return tempUser;
        } else {
            System.out.println("Пользователя с ID " + id + " не существует!");
            return null;
        }
    }

    @Override
    public List<UserDataSet> findAllUsers() throws DBException, SQLException {
        return userDAO.findAll();
    }
}
