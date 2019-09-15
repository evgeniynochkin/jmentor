package factories;

import DAO.UserDAO;
import DAO.UserDAOJDBCImpl;

public class UserDAOJDBCFactory implements UserDAOFactory {

    @Override
    public UserDAO workDAO() {
        return new UserDAOJDBCImpl();
    }
}
