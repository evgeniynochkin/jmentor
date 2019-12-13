package task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.DAO.UserDAO;
import task.model.UserDataSet;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
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
    public void removeUser(long id) {
        this.userDAO.removeUser(id);
    }

    @Override
    @Transactional
    public UserDataSet getUserByLogin(String login) {
        return this.getUserByLogin(login);
    }

    @Override
    @Transactional
    public UserDataSet getUserById(long id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public List<UserDataSet> findAllUsers() {
        return this.userDAO.findAll();
    }
}
