package factories;

import DAO.UserDAO;
import DAO.UserDAOHibernateImpl;
import DAO.UserDAOJDBCImpl;

public class UserDAOFactoryImpl implements UserDAOFactory {

    @Override
    public UserDAO getHibernateDAO() {
        return new UserDAOHibernateImpl();
    }

    @Override
    public UserDAO getJDBCDAO() {
        return new UserDAOJDBCImpl();
    }
}
