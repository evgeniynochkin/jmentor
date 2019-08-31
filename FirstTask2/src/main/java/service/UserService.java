package service;

import exception.DBException;
import model.UserDataSet;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    public String addUser(UserDataSet uds) throws DBException, SQLException;

    public void updateUser(UserDataSet uds, Integer id) throws DBException;

    public void removeUser(int id) throws DBException;

    public UserDataSet getUserByLogin(String login) throws DBException;

    public UserDataSet getUserById(Integer id) throws DBException;

    public List<UserDataSet> findAllUsers() throws DBException;
}
