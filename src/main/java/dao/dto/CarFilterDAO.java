package dao.dto;

import dao.interfaces.FilterDAO;
import database.DataBaseConnection;
import dto.CarFilterDTO;
import entity.Car;
import entity.mapper.CarMapper;
import utils.ReadPropertiesFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarFilterDAO implements FilterDAO<Car, CarFilterDTO> {
    private Connection connection;
    private final String SELECT_BY_CAR_DTO;

    public CarFilterDAO(Connection connection) {
        this.connection = connection;

        ReadPropertiesFile propertySql = new ReadPropertiesFile();
        SELECT_BY_CAR_DTO = propertySql.getSqlProperty("SELECT_BY_CAR_DTO");
    }
    @Override
    public List<Car> getFilteredObjects(CarFilterDTO dto) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SELECT_BY_CAR_DTO);
        ps.setString(1, dto.getName());
        ps.setString(2, dto.getName());
        setNullOrInt(ps,3, dto.getLevelId());
        setNullOrInt(ps, 4, dto.getLevelId());
        setNullOrInt(ps, 5, dto.getLabelId());
        setNullOrInt(ps, 6, dto.getLabelId());
        ps.setInt(7, dto.getPriceFrom());
        ps.setInt(8, dto.getPriceTo());
        ps.setInt(9, dto.getPriceFrom());
        ps.setInt(10, dto.getPriceTo());

        ResultSet resultSet = ps.executeQuery();
        List<Car> carsList = new ArrayList<>();

        while (resultSet.next()) {
            carsList.add(CarMapper.mapRow(resultSet));
        }
        return carsList;
    }

    public void setNullOrInt(PreparedStatement ps, int index,Integer value) throws SQLException {
        if(value == null) {
            ps.setNull(index, Types.INTEGER);
        } else {
            ps.setInt(index, value);
        }
    }
}
