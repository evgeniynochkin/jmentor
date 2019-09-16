package properties;

public class PropertyDB {

    public final Boolean useHibernate = false;

    //Общие свойства
    public static final String DB_DRIVER = "org.postgresql.Driver";
    public final static String DB_URL = "jdbc:postgresql://localhost:5432/ft";
    public final static String DB_USER = "postgres";
    public final static String DB_PASSWORD = "1111";

    //Настройки Hibernate
    public static final String HIBERNATE_DIALECT = "org.hibernate.dialect.PostgreSQL10Dialect";
    public static final String hibernate_show_sql = "true";
    public static final String hibernate_hbm2ddl_auto = "update";
}
