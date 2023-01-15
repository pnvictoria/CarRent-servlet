package dao;

import dao.interfaces.MainDAO;
import entity.State;
import entity.mapper.StateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDAO implements MainDAO<State> {
    private static final Logger LOG = LoggerFactory.getLogger(StateDAO.class);

    private Connection connection;
    private final String INSERT_STATE;
    private final String SELECT_ALL_STATE;
    private final String SELECT_STATE_BY_ID;
    private final String SELECT_STATE_BY_NAME;
    private final String UPDATE_STATE_BY_ID;
    private final String DELETE_STATE_BY_ID;

    public StateDAO(Connection connection) {
        this.connection = connection;

        ReadPropertiesFile propertySql = new ReadPropertiesFile();
        INSERT_STATE = propertySql.getSqlProperty("INSERT_STATE");
        SELECT_ALL_STATE = propertySql.getSqlProperty("SELECT_ALL_STATE");
        SELECT_STATE_BY_ID = propertySql.getSqlProperty("SELECT_STATE_BY_ID");
        SELECT_STATE_BY_NAME = propertySql.getSqlProperty("SELECT_STATE_BY_NAME");
        UPDATE_STATE_BY_ID = propertySql.getSqlProperty("UPDATE_STATE_BY_ID");
        DELETE_STATE_BY_ID = propertySql.getSqlProperty("DELETE_STATE_BY_ID");
    }

    @Override
    public void addObject(State obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_STATE);
            ps.setString(1, obj.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_STATE_BY_ID);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateObject(State obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_STATE_BY_ID);
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public State getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_STATE_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return StateMapper.mapRow(rs);
        }
        return State.newBuilder().build();
    }

    @Override
    public List<State> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_STATE);
        List<State> levelsList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            levelsList.add(StateMapper.mapRow(resultSet));
        }
        return levelsList;
    }

    @Override
    public List<State> getByItem(State obj) throws SQLException {
        return null;
    }
}