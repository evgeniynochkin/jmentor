package task.DAO;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import task.model.UserDataSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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

    @Override
    @SuppressWarnings("unchecked")
    public List<UserDataSet> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM UserDataSet", UserDataSet.class);
        List<UserDataSet> users = query.list();
        return users;
    }
}
