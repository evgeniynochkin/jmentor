package dao;

import model.UsersDataSet;
import org.hibernate.Session;

import java.util.List;

/**
 * @author Evgeniy Nochkin
 * @since 1.1
 */

public class UsersDAOImpl implements UsersDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void addUser(UsersDataSet uds) {
        session.persist(uds);
    }

    @Override
    public void updateUser(UsersDataSet uds) {
        session.update(uds);
    }

    @Override
    public void removeUser(int id) {
        UsersDataSet uds = (UsersDataSet) session.load(UsersDataSet.class, new Integer(id));

        if(uds!=null) {
            session.delete(uds);
        }
    }

    @Override
    public UsersDataSet getUserById(int id) {
        UsersDataSet uds = (UsersDataSet) session.load(UsersDataSet.class, new Integer(id));
        return uds;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UsersDataSet> listUsers() {
        List<UsersDataSet> usersList = session.createQuery("from USERS").list();
        return usersList;
    }
}
