package task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.DAO.UserDAO;
import task.model.UserDataSet;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) { this.userDAO = userDAO; }

//    public void addUser(UserDataSet uds) { this.userDAO.save(uds); }
//
//    public void updateUser(UserDataSet uds) { this.userDAO.save(uds); }
//
//    public void removeUser(long id) {
//        this.userDAO.deleteById(id);
//    }
//
//    public UserDataSet getUserByLogin(String login) { return null; }
//
//    public Optional<UserDataSet> getUserById(long id) {
//        return this.userDAO.findById(id);
//    }

    public List<UserDataSet> findAllUsers() { return (List<UserDataSet>) this.userDAO.findAll(); }
}
