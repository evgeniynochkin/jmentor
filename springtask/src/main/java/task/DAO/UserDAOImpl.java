package task.DAO;

import task.model.UserDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addUser(UserDataSet uds) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(uds);
    }

    @Override
    public void updateUser(UserDataSet uds) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(uds);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserDataSet uds = (UserDataSet) session.load(UserDataSet.class, new Integer(id));
        if (null != uds) { session.delete(uds); }
    }

    @Override
    public UserDataSet getUserByLogin(String fLogin) {
        Session session = this.sessionFactory.getCurrentSession();
        UserDataSet uds = (UserDataSet) session.load(UserDataSet.class, new String(fLogin));
        return uds;
    }

    @Override
    public UserDataSet getUserById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserDataSet uds = (UserDataSet) session.load(UserDataSet.class, new Integer(id));
        return uds;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDataSet> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserDataSet> users = session.createQuery("from Users").list();
        return users;
    }
}
