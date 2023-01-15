package entity.mapper;

import entity.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper {
    public static Car mapRow(ResultSet rs) throws SQLException {
        return Car.newBuilder()
                .setId(rs.getInt("car_id"))
                .setName(rs.getString("car_name"))
                .setPrice(rs.getInt("car_price"))
                .setJpg(rs.getString("car_jpg"))
                .setLevel(LevelMapper.mapRow(rs))
                .setLabel(LabelMapper.mapRow(rs))
                .setDesc(rs.getString("car_desc"))
                .setBlock(rs.getBoolean("car_block"))
                .build();
    }
}
