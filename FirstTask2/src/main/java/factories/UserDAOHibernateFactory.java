package factories;

import DAO.UserDAO;
import DAO.UserDAOHibernateImpl;

public class UserDAOHibernateFactory extends UserDAOFactory {

    @Override
    public UserDAO getDAO() {
        return new UserDAOHibernateImpl();
    }
}
