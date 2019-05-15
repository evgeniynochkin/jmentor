package service;

import dao.UsersDAO;
import model.UsersDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import property.DBproperty;

import javax.transaction.Transactional;
import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersDAO usersDAO;

    private final SessionFactory sessionFactory;

    public UsersServiceImpl() {
        Configuration configuration = new DBproperty().H2Configuration();
        sessionFactory = createSessionFactory(configuration);
    }

    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public void addUser(UsersDataSet uds) {
        this.usersDAO.addUser(uds);
    }

    @Override
    public void updateUser(UsersDataSet uds) {
        this.usersDAO.updateUser(uds);
    }

    @Override
    public void removeUser(int id) {
        this.usersDAO.removeUser(id);
    }

    @Override
    public UsersDataSet getUserById(int id) {
        return this.usersDAO.getUserById(id);
    }

    @Override
    public List<UsersDataSet> listUsers() {
        return this.usersDAO.listUsers();
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
