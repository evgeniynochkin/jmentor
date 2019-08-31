package DAO;

import model.UserDataSet;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    public void addUser(UserDataSet uds) throws SQLException;

    public void updateUser(UserDataSet uds, Integer id);

    public void removeUser(int id);

    public UserDataSet getUserByLogin(String login);

    public UserDataSet getUserById(Integer id);

    public List<UserDataSet> findAll();
}
