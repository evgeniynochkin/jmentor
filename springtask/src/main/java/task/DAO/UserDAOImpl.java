package task.DAO;

import org.springframework.stereotype.Repository;
import task.model.UserDataSet;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(UserDataSet uds) {
        entityManager.persist(uds);
    }

    @Override
    public void updateUser(UserDataSet uds) {
        entityManager.merge(uds);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public UserDataSet getUserByLogin(String fLogin) {
        return (UserDataSet) entityManager.find(UserDataSet.class, fLogin);
    }

    @Override
    public UserDataSet getUserById(long id) {
        return (UserDataSet) entityManager.find(UserDataSet.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserDataSet> findAll() {
        Query query = entityManager.createQuery("FROM UserDataSet", UserDataSet.class);
        return query.getResultList();
    }
}
