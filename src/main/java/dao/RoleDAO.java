package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Role;
import entity.mapper.RoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements MainDAO<Role> {
    private static final Logger LOG = LoggerFactory.getLogger(RoleDAO.class);

    private Connection connection;
    private final String INSERT_ROLE;
    private final String SELECT_ALL_ROLE;
    private final String SELECT_ROLE_BY_ID;
    private final String SELECT_ROLE_BY_NAME;
    private final String UPDATE_ROLE_BY_ID;
    private final String DELETE_ROLE_BY_ID;

    public RoleDAO(Connection connection) {
        this.connection = connection;

        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        INSERT_ROLE = propertyPage.getSqlProperty("INSERT_ROLE");
        SELECT_ALL_ROLE = propertyPage.getSqlProperty("SELECT_ALL_ROLE");
        SELECT_ROLE_BY_ID = propertyPage.getSqlProperty("SELECT_ROLE_BY_ID");
        SELECT_ROLE_BY_NAME = propertyPage.getSqlProperty("SELECT_ROLE_BY_NAME");
        UPDATE_ROLE_BY_ID = propertyPage.getSqlProperty("UPDATE_ROLE_BY_ID");
        DELETE_ROLE_BY_ID = propertyPage.getSqlProperty("DELETE_ROLE_BY_ID");
    }

    @Override
    public void addObject(Role obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_ROLE);
            ps.setString(1, obj.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_ROLE_BY_ID);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateObject(Role obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_ROLE_BY_ID);
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Role getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ROLE_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return RoleMapper.mapRow(rs);
        }
        return Role.newBuilder().build();
    }

    @Override
    public List<Role> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ROLE);
        List<Role> rolesList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            rolesList.add(RoleMapper.mapRow(resultSet));
        }
        return rolesList;
    }

    @Override
    public List<Role> getByItem(Role obj) throws SQLException {
        PreparedStatement ps = null;
        List<Role> roleList = new ArrayList<>();
        try {
            ps = connection.prepareStatement(SELECT_ROLE_BY_NAME);
            ps.setString(1, obj.getName());
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            roleList.add(RoleMapper.mapRow(resultSet));
        }
        return roleList;
    }
}
