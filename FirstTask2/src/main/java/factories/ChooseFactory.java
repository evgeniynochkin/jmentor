package factories;

import properties.PropertyDB;

public class ChooseFactory {

    public UserDAOFactory GetDAO() {
        if (new PropertyDB().useHibernate) {
            return new UserDAOHibernateFactory();
        } else {
            return new UserDAOJDBCFactory();
        }
    }
}
