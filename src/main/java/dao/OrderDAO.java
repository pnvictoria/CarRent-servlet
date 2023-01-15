package dao;

import dao.interfaces.MainDAO;
import entity.Order;
import entity.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements MainDAO<Order> {
    private static final Logger LOG = LoggerFactory.getLogger(OrderDAO.class);

    private Connection connection;
    private final String INSERT_ORDER;
    private final String SELECT_ALL_ORDER;
    private final String SELECT_ORDER_BY_USER_ID;
    private final String UPDATE_ORDER_BY_ID;
    private final String DELETE_ORDER_BY_ID;

    public OrderDAO(Connection connection) {
        this.connection = connection;

        ReadPropertiesFile propertySql = new ReadPropertiesFile();
        INSERT_ORDER = propertySql.getSqlProperty("INSERT_ORDER");
        SELECT_ALL_ORDER = propertySql.getSqlProperty("SELECT_ALL_ORDER");
        SELECT_ORDER_BY_USER_ID = propertySql.getSqlProperty("SELECT_ORDER_BY_USER_ID");;
        UPDATE_ORDER_BY_ID = propertySql.getSqlProperty("UPDATE_ORDER_BY_ID");
        DELETE_ORDER_BY_ID = propertySql.getSqlProperty("DELETE_ORDER_BY_ID");
    }

    @Override
    public void addObject(Order obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_ORDER);
            ps.setLong(1, obj.getUser().getId());
            ps.setString(2, obj.getPhone());
            ps.setLong(3, obj.getCar().getId());
            ps.setLong(4, obj.getState().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_ORDER_BY_ID);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateObject(Order obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_ORDER_BY_ID);
            ps.setLong(1, obj.getState().getId());
            ps.setLong(2, obj.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Order getObjectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Order> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_ORDER);
        List<Order> orderList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            orderList.add(OrderMapper.mapRow(resultSet));
        }
        return orderList;
    }

    @Override
    public List<Order> getByItem(Order obj) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ORDER_BY_USER_ID);
        ps.setLong(1, obj.getUser().getId());
        List<Order> orderList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            orderList.add(OrderMapper.mapRow(resultSet));
        }
        return orderList;
    }
}
