package service;

import model.UsersDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import property.DBproperty;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {}

    private static Configuration configuration = new DBproperty().H2Configuration();

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                configuration.addAnnotatedClass(UsersDataSet.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
                builder.applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return sessionFactory;
    }
}
