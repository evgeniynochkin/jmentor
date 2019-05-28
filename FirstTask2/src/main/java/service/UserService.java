package service;

import exception.DBException;
import model.UserDataSet;

import java.util.List;

public interface UserService {

    public String addUser(UserDataSet uds) throws DBException;

    public void updateUser(UserDataSet uds) throws DBException;

    public void removeUser(int id) throws DBException;

    public UserDataSet getUserByLogin(String login) throws DBException;

    public List<UserDataSet> findAllUsers() throws DBException;
}
