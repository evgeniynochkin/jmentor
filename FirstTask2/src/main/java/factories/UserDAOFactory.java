package factories;

import DAO.UserDAO;

public interface UserDAOFactory {
     UserDAO getDAO();
}
