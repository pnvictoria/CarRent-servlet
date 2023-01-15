package dao;

import dao.interfaces.MainDAO;
import database.DataBaseConnection;
import entity.Car;
import entity.Label;
import entity.mapper.CarMapper;
import entity.mapper.LevelMapper;
import utils.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements MainDAO<Car> {
    private Connection connection;

    private final String INSERT_CAR;
    private final String SELECT_ALL_CARS;
    private final String SELECT_CAR_BY_ID;
    private final String SELECT_CAR_BY_NAME;
    private final String UPDATE_CAR_BY_ID;
    private final String DELETE_CAR_BY_ID;

    public CarDAO(Connection connection) {
        this.connection = connection;

        ReadPropertiesFile propertySql = new ReadPropertiesFile();
        INSERT_CAR = propertySql.getSqlProperty("INSERT_CAR");
        SELECT_ALL_CARS = propertySql.getSqlProperty("SELECT_ALL_CARS");
        SELECT_CAR_BY_ID = propertySql.getSqlProperty("SELECT_CAR_BY_ID");
        SELECT_CAR_BY_NAME = propertySql.getSqlProperty("SELECT_CAR_BY_NAME");
        UPDATE_CAR_BY_ID = propertySql.getSqlProperty("UPDATE_CAR_BY_ID");
        DELETE_CAR_BY_ID = propertySql.getSqlProperty("DELETE_CAR_BY_ID");
    }

    @Override
    public void addObject(Car obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_CAR);
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getPrice());
            ps.setString(3, obj.getJpg());
            ps.setLong(4, obj.getLevel().getId());
            ps.setLong(5, obj.getLabel().getId());
            ps.setString(6, obj.getDesc());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteObject(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID);
        ps.setLong(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateObject(Car obj) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_BY_ID);
            ps.setString(1, obj.getName());
            ps.setLong(2, obj.getPrice());
            ps.setString(3, obj.getJpg());
            ps.setLong(4, obj.getLevel().getId());
            ps.setLong(5, obj.getLabel().getId());
            ps.setString(6, obj.getDesc());
            ps.setLong(7, obj.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Car getObjectById(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_CAR_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return CarMapper.mapRow(rs);
        }
        return Car.newBuilder().build();
    }

    @Override
    public List<Car> getObjects() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CARS);
        List<Car> carsList = new ArrayList<>();
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            carsList.add(CarMapper.mapRow(resultSet));
        }
        return carsList;
    }

    @Override
    public List<Car> getByItem(Car obj) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_CAR_BY_NAME);
        ps.setString(1, obj.getName());
        ResultSet rs = ps.executeQuery();
        List<Car> carList = new ArrayList<>();
        while (rs.next()) {
            carList.add(CarMapper.mapRow(rs));
        }
        return carList;
    }
}
