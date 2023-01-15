package entity.mapper;

import entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper {
    public static Order mapRow(ResultSet rs) throws SQLException {
        return Order.newBuilder()
                .setId(rs.getInt("order_id"))
                .setUser(UserMapper.mapRow(rs))
                .setCar(CarMapper.mapRow(rs))
                .setPhone(rs.getString("order_phone"))
                .setState(StateMapper.mapRow(rs))
                .build();
    }
}
