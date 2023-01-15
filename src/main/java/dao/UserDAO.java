package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.User;
import entity.mapper.UserMapper;
import utils.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements MainDAO<User> {
    private Connection connection;
    private final String INSERT_USER;
    private final String SELECT_ALL_USERS;
    private final String SELECT_USER_BY_ID;
    private final String UPDATE_USER_BY_ID;
    private final String DELETE_USER_BY_ID;
    private final String SELECT_USER_BY_EMAIL;

    public UserDAO(Connection connection) {
        this.connection = connection;

        ReadPropertiesFile propertySql = new ReadPropertiesFile();
        INSERT_USER = propertySql.getSqlProperty("INSERT_USER");
        SELECT_ALL_USERS = propertySql.getSqlProperty("SELECT_ALL_USERS");
        SELECT_USER_BY_ID = propertySql.getSqlProperty("SELECT_USER_BY_ID");
        UPDATE_USER_BY_ID = propertySql.getSqlProperty("UPDATE_USER_BY_ID");
        DELETE_USER_BY_ID = propertySql.getSqlProperty("DELETE_USER_BY_ID");
        SELECT_USER_BY_EMAIL = propertySql.getSqlProperty("SELECT_USER_BY_EMAIL");
    }

    @Override
    public void addObject(User obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getSurname());
            ps.setBoolean(3, obj.isSex());
            ps.setString(4, obj.getDate());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getPassword());
            ps.setString(7, "avatar.png");
            ps.setLong(8, obj.getRole().getId());
            ps.setBoolean(9, false);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_USER_BY_ID);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateObject(User obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USER_BY_ID);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getSurname());
            ps.setBoolean(3, obj.isSex());
            ps.setString(4, obj.getDate());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getPassword());
            ps.setString(7, obj.getAvatar());
            ps.setLong(8, obj.getRole().getId());
            ps.setLong(9, obj.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return UserMapper.mapRow(rs);
        }
        return User.newBuilder().build();
    }

    @Override
    public List<User> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
        List<User> usersList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            usersList.add(UserMapper.mapRow(resultSet));
        }
        return usersList;
    }

    @Override
    public List<User> getByItem(User obj) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_EMAIL);
        ps.setString(1, obj.getEmail());
        List<User> usersList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            usersList.add(UserMapper.mapRow(resultSet));
        }
        return usersList;
    }
}
