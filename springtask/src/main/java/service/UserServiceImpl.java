package service;

import DAO.UserDAO;
import model.UserDataSet;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setUserDSO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(UserDataSet uds) {
        this.userDAO.addUser(uds);
    }

    @Override
    @Transactional
    public void updateUser(UserDataSet uds) {
        this.userDAO.updateUser(uds);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDAO.removeUser(id);
    }

    @Override
    @Transactional
    public UserDataSet getUserByLogin(String login) {
        return this.getUserByLogin(login);
    }

    @Override
    @Transactional
    public UserDataSet getUserById(Integer id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public List<UserDataSet> findAllUsers() {
        return this.userDAO.findAll();
    }
}
