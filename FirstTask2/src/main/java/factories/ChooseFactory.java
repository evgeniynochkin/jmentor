package factories;

import service.DBMakeCon;

public class ChooseFactory {

    private DBMakeCon dbMakeCon = DBMakeCon.getInstance();

    public UserDAOFactory GetDAO() {
        if (dbMakeCon.useORM.equals("useHibernate")) {
            return new UserDAOHibernateFactory();
        } else {
            return new UserDAOJDBCFactory();
        }
    }
}
