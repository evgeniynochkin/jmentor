package factories;

import DAO.UserDAO;

public abstract class UserDAOFactory {

     public abstract UserDAO getDAO();
}
