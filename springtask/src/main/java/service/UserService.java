package service;

import model.UserDataSet;
import java.util.List;

public interface UserService {

    public String addUser(UserDataSet uds);
    public void updateUser(UserDataSet uds);
    public void removeUser(int id);
    public UserDataSet getUserByLogin(String login);
    public UserDataSet getUserById(Integer id);
    public List<UserDataSet> findAllUsers();
}
