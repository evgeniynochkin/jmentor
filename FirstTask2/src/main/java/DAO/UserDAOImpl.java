package DAO;

import model.UserDataSet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.DBSessionFactory;
import service.HibernateSessionFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final static String JDBC_URL = "jdbc:postgresql://localhost:5432/ft";
    private final static String JDBC_USER = "postgres";
    private final static String JDBC_PASSWORD = "1111";
    private Connection jdbcConnection;

//    private Session session;
    private DBSessionFactory connection = new DBSessionFactory();

//    public void openSession() {
//        this.session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//    }
//
//    public void closeSession() {
//        this.session.close();
//    }

    @Override
    public void addUser(UserDataSet uds) throws SQLException {
        //реализация через JDBC
        String sql = "INSERT INTO users (login, password, name) VALUES (?,?,?)";

        //connect();
        jdbcConnection = connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, uds.getLogin());
        statement.setString(2, uds.getPassword());
        statement.setString(3, uds.getName());
        statement.executeUpdate();
        statement.close();

        //disconnect();
        connection.disconnect(jdbcConnection);

        //реализация через Hibernate
//        openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(uds);
//        transaction.commit();
//        closeSession();
    }

    @Override
    public void updateUser(UserDataSet uds, Integer id) throws SQLException {
        //реализация через JDBC
        String sql = "UPDATE users SET name = ?, login = ?, password = ? WHERE id=?";

        jdbcConnection = connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, uds.getName());
        statement.setString(2, uds.getLogin());
        statement.setString(3,uds.getPassword());
        statement.setInt(4, id);
        statement.executeUpdate();
        statement.close();

        connection.disconnect(jdbcConnection);

        //реализация через Hibernate
//        openSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("update UserDataSet set login = :paramLogin" +
//                ", password = :paramPassword" +
//                ", name = :paramName" +
//                " where id = :paramId");
//        query.setParameter("paramLogin", uds.getLogin());
//        query.setParameter("paramPassword", uds.getPassword());
//        query.setParameter("paramName", uds.getName());
//        query.setParameter("paramId", id);
//        int result = query.executeUpdate();
//        transaction.commit();
//        closeSession();
    }

    @Override
    public void removeUser(int id) throws SQLException {
        //реализация через JDBC
        String sql = "DELETE FROM users WHERE id=?";

        jdbcConnection = connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();

        connection.disconnect(jdbcConnection);

        //реализация через Hibernate
//        openSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("delete UserDataSet where id = :paramId");
//        query.setParameter("paramId", id);
//        int result = query.executeUpdate();
//        transaction.commit();
//        closeSession();
//        System.out.println(result);
    }

    @Override
    public UserDataSet getUserByLogin(String fLogin) throws SQLException {
        //реализация через JDBC
        UserDataSet uds = new UserDataSet();
        String sql = "SELECT * FROM users WHERE login=?";

        jdbcConnection = connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, fLogin);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            uds.setLogin(resultSet.getString("login"));
            uds.setPassword(resultSet.getString("password"));
            uds.setName(resultSet.getString("name"));
        }

        resultSet.close();
        statement.close();
        connection.disconnect(jdbcConnection);

        return uds;

        //реализация через Hibernate
//        openSession();
//        Query query = session.createQuery("from UserDataSet where login = :paramLogin", UserDataSet.class);
//        query.setParameter("paramLogin", fLogin);
//        UserDataSet uds = (UserDataSet) query.uniqueResult();
//        closeSession();
//        return uds;
    }

    @Override
    public UserDataSet getUserById(Integer id) throws SQLException {
        //реализация через JDBC
        UserDataSet uds = new UserDataSet();
        String sql = "SELECT * FROM users WHERE id=?";

        jdbcConnection = connection.connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            uds.setLogin(resultSet.getString("login"));
            uds.setPassword(resultSet.getString("password"));
            uds.setName(resultSet.getString("name"));
        }

        resultSet.close();
        statement.close();
        connection.disconnect(jdbcConnection);

        return uds;

        //реализация через Hibernate
//        openSession();
//        Query query = session.createQuery("from UserDataSet where id = :paramId", UserDataSet.class);
//        query.setParameter("paramId", id);
//        UserDataSet uds = (UserDataSet) query.uniqueResult();
//        closeSession();
//        return uds;
    }

    @Override
    public List<UserDataSet> findAll() throws SQLException {
        //реализация через JDBC
        List<UserDataSet> usersList = new ArrayList<>();

        String sql = "SELECT * FROM users";

        jdbcConnection = connection.connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            UserDataSet uds = new UserDataSet();
            uds.setId(resultSet.getInt("id"));
            uds.setLogin(resultSet.getString("login"));
            uds.setPassword(resultSet.getString("password"));
            uds.setName(resultSet.getString("name"));

            usersList.add(uds);
        }

        resultSet.close();
        statement.close();

        connection.disconnect(jdbcConnection);

        return usersList;

        //реализация через Hibernate
//        openSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery("FROM UserDataSet");
//        List<UserDataSet> users = query.list();
//        transaction.commit();
//        closeSession();
//        return users;
    }
}
