package dao;

import model.UsersDataSet;

import java.util.List;

public interface UsersDAO {

    public void addUser(UsersDataSet uds);

    public void updateUser(UsersDataSet uds);

    public void removeUser(int id);

    public UsersDataSet getUserById(int id);

    public List<UsersDataSet> listUsers();
}
