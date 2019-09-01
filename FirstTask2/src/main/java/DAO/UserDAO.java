package DAO;

import model.UserDataSet;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    public void addUser(UserDataSet uds) throws SQLException;

    public void updateUser(UserDataSet uds, Integer id) throws SQLException;

    public void removeUser(int id) throws SQLException;

    public UserDataSet getUserByLogin(String login) throws SQLException;

    public UserDataSet getUserById(Integer id) throws SQLException;

    public List<UserDataSet> findAll() throws SQLException;
}
