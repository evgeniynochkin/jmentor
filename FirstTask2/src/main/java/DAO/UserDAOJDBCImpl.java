package DAO;

import model.UserDataSet;
import service.DBMakeCon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJDBCImpl implements UserDAO {

    private Connection jdbcConnection;

    private DBMakeCon dbMakeCon = DBMakeCon.getInstance();

    @Override
    public void addUser(UserDataSet uds) throws SQLException {

        String sql = "INSERT INTO users (login, password, name, role) VALUES (?,?,?,?)";

        this.jdbcConnection = dbMakeCon.getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, uds.getLogin());
        statement.setString(2, uds.getPassword());
        statement.setString(3, uds.getName());
        statement.setString(4, uds.getRole());
        statement.executeUpdate();
        statement.close();

        dbMakeCon.disconnect(jdbcConnection);
    }

    @Override
    public void updateUser(UserDataSet uds, Integer id) throws SQLException {
        String sql = "UPDATE users SET name = ?, login = ?, password = ? WHERE id=?";

        this.jdbcConnection = dbMakeCon.getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, uds.getName());
        statement.setString(2, uds.getLogin());
        statement.setString(3,uds.getPassword());
        statement.setInt(4, id);
        statement.executeUpdate();
        statement.close();

        dbMakeCon.disconnect(jdbcConnection);
    }

    @Override
    public void removeUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id=?";

        this.jdbcConnection = dbMakeCon.getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();

        dbMakeCon.disconnect(jdbcConnection);
    }

    @Override
    public UserDataSet getUserByLogin(String fLogin) throws SQLException {
        UserDataSet uds = new UserDataSet();
        String sql = "SELECT * FROM users WHERE login=?";

        this.jdbcConnection = dbMakeCon.getConnection();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, fLogin);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            uds.setLogin(resultSet.getString("login"));
            uds.setPassword(resultSet.getString("password"));
            uds.setName(resultSet.getString("name"));
            uds.setRole(resultSet.getString("role"));
        }

        resultSet.close();
        statement.close();
        dbMakeCon.disconnect(jdbcConnection);

        return uds;
    }

    @Override
    public UserDataSet getUserById(Integer id) throws SQLException {
        UserDataSet uds = new UserDataSet();
        String sql = "SELECT * FROM users WHERE id=?";

        this.jdbcConnection = dbMakeCon.getConnection();

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
        dbMakeCon.disconnect(jdbcConnection);

        return uds;
    }

    @Override
    public List<UserDataSet> findAll() throws SQLException {
        List<UserDataSet> usersList = new ArrayList<>();

        String sql = "SELECT * FROM users";

        this.jdbcConnection = dbMakeCon.getConnection();

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

        dbMakeCon.disconnect(jdbcConnection);

        return usersList;
    }
}
