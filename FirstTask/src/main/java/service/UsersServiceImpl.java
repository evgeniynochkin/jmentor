package service;

import dao.UsersDAO;
import model.UsersDataSet;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersDAO usersDAO;

    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    @Transactional
    public void addUser(UsersDataSet uds) {
        this.usersDAO.addUser(uds);
    }

    @Override
    @Transactional
    public void updateUser(UsersDataSet uds) {
        this.usersDAO.updateUser(uds);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.usersDAO.removeUser(id);
    }

    @Override
    @Transactional
    public UsersDataSet getUserById(int id) {
        return this.usersDAO.getUserById(id);
    }

    @Override
    @Transactional
    public List<UsersDataSet> listUsers() {
        return this.usersDAO.listUsers();
    }
}
