package factories;

import properties.PropertyDB;

public class ChooseFactory {

    public PropertyDB propertyDB = new PropertyDB();

    public UserDAOFactory GetDAO() {
        if (propertyDB.useHibernate) {
            return new UserDAOHibernateFactory();
        } else {
            return new UserDAOJDBCFactory();
        }
    }
}
