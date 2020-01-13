package task.DAO;

import task.model.UserDataSet;

import java.util.List;

public interface UserDAO {

    public void addUser(UserDataSet uds);
    public void updateUser(UserDataSet uds);
    public void removeUser(long id);
    public UserDataSet getUserByLogin(String login);
    public UserDataSet getUserById(long id);
    public List<UserDataSet> findAll();
}