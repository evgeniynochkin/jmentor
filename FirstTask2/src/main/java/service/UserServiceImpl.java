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
    public void updateUser(UserDataSet uds) throws DBException {

    }

    @Override
    public void removeUser(int id) throws DBException {

    }

    @Override
    public UserDataSet getUserByLogin(String login) throws DBException {
        if (userDAO.getUserByLogin(login) != null) {
            return userDAO.getUserByLogin(login);
        } else {
            System.out.println("Пользователя с логином " + login + " не существует!");
            return null;
        }
    }

    @Override
    public List<UserDataSet> findAllUsers() throws DBException {
        return userDAO.findAll();
    }
}
