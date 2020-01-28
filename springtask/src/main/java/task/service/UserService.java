package task.service;

import task.model.UserDataSet;
import java.util.List;
import java.util.Optional;

public interface UserService {

    public boolean saveUser(UserDataSet uds);
//    public void updateUser(UserDataSet uds);
    public void removeUser(long id);
    public UserDataSet findUserDataSetByLogin(String login);
    public UserDataSet getUserById(long id);
    public List<UserDataSet> findAllUsers();
}
