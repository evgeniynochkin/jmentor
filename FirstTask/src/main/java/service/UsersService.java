package service;

import exception.DBException;
import model.UsersDataSet;

import java.util.List;

public interface UsersService {

    public void addUser(UsersDataSet uds) throws DBException;

    public void updateUser(UsersDataSet uds) throws DBException;

    public void removeUser(int id) throws DBException;

    public UsersDataSet getUserById(int id) throws DBException;

    public List<UsersDataSet> listUsers() throws DBException;
}
