package properties;

import factories.UserDAOFactory;
import factories.UserDAOHibernateFactory;
import factories.UserDAOJDBCFactory;

public class PropertyWork {

    public PropertyDB propertyDB;

    public UserDAOFactory GetDAO() {
        if (propertyDB.useHibernate) {
            return new UserDAOHibernateFactory();
        } else {
            return new UserDAOJDBCFactory();
        }
    }
}
