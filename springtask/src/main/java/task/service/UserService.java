package task.service;

import task.model.UserDataSet;
import java.util.List;
import java.util.Optional;

public interface UserService {

//    public void addUser(UserDataSet uds);
//    public void updateUser(UserDataSet uds);
//    public void removeUser(long id);
//    public UserDataSet getUserByLogin(String login);
//    public Optional<UserDataSet> getUserById(long id);
    public List<UserDataSet> findAllUsers();
}