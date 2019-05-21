package service;

import exception.DBException;
import model.UserDataSet;

public interface UserService {

    public void addUser(UserDataSet uds) throws DBException;

    public void updateUser(UserDataSet uds) throws DBException;

    public void removeUser(int id) throws DBException;

    public UserDataSet getUserById(int id) throws DBException;
}
