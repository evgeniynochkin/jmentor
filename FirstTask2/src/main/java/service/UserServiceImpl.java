package service;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import exception.DBException;
import model.UserDataSet;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    public UserServiceImpl() {}

    @Override
    public String addUser(UserDataSet uds) throws DBException {
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
    public void updateUser(UserDataSet uds, Integer id) throws DBException {
        userDAO.updateUser(uds, id);
    }

    @Override
    public void removeUser(int id) throws DBException {
        userDAO.removeUser(id);
    }

    @Override
    public UserDataSet getUserByLogin(String login) throws DBException {
        UserDataSet tempUser =  userDAO.getUserByLogin(login);
        if (tempUser != null) {
            return tempUser;
        } else {
            System.out.println("Пользователя с логином " + login + " не существует!");
            return null;
        }
    }

    @Override
    public UserDataSet getUserById(Integer id) throws DBException {
        UserDataSet tempUser =  userDAO.getUserById(id);
        if (tempUser != null) {
            return tempUser;
        } else {
            System.out.println("Пользователя с логином " + id + " не существует!");
            return null;
        }
    }

    @Override
    public List<UserDataSet> findAllUsers() throws DBException {
        return userDAO.findAll();
    }
}
