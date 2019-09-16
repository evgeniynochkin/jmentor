package DAO;

import model.UserDataSet;
import service.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJDBCImpl implements UserDAO {
    private final static String JDBC_URL = "jdbc:postgresql://localhost:5432/ft";
    private final static String JDBC_USER = "postgres";
    private final static String JDBC_PASSWORD = "1111";
    private Connection jdbcConnection;

    private DBHelper helper = DBHelper.getInstance();

    @Override
    public void addUser(UserDataSet uds) throws SQLException {

        String sql = "INSERT INTO users (login, password, name) VALUES (?,?,?)";

        this.jdbcConnection = helper.getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, uds.getLogin());
        statement.setString(2, uds.getPassword());
        statement.setString(3, uds.getName());
        statement.executeUpdate();
        statement.close();

        helper.disconnect(jdbcConnection);
    }

    @Override
    public void updateUser(UserDataSet uds, Integer id) throws SQLException {
        String sql = "UPDATE users SET name = ?, login = ?, password = ? WHERE id=?";

        this.jdbcConnection = helper.getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, uds.getName());
        statement.setString(2, uds.getLogin());
        statement.setString(3,uds.getPassword());
        statement.setInt(4, id);
        statement.executeUpdate();
        statement.close();

        helper.disconnect(jdbcConnection);
    }

    @Override
    public void removeUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id=?";

        this.jdbcConnection = helper.getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();

        helper.disconnect(jdbcConnection);
    }

    @Override
    public UserDataSet getUserByLogin(String fLogin) throws SQLException {
        UserDataSet uds = new UserDataSet();
        String sql = "SELECT * FROM users WHERE login=?";

        this.jdbcConnection = helper.getConnection();

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
        helper.disconnect(jdbcConnection);

        return uds;
    }

    @Override
    public UserDataSet getUserById(Integer id) throws SQLException {
        UserDataSet uds = new UserDataSet();
        String sql = "SELECT * FROM users WHERE id=?";

        this.jdbcConnection = helper.getConnection();

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
        helper.disconnect(jdbcConnection);

        return uds;
    }

    @Override
    public List<UserDataSet> findAll() throws SQLException {
        List<UserDataSet> usersList = new ArrayList<>();

        String sql = "SELECT * FROM users";

        this.jdbcConnection = helper.getConnection();

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

        helper.disconnect(jdbcConnection);

        return usersList;
    }
}
