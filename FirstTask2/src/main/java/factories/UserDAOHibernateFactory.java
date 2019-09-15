package factories;

import DAO.UserDAO;
import DAO.UserDAOHibernateImpl;

public class UserDAOHibernateFactory implements UserDAOFactory {

    @Override
    public UserDAO workDAO() {
        return new UserDAOHibernateImpl();
    }
}
