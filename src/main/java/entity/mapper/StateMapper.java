package entity.mapper;

import entity.State;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StateMapper {
    public static State mapRow(ResultSet rs) throws SQLException {
        return State.newBuilder()
                .setId(rs.getInt("state_id"))
                .setName(rs.getString("state_name"))
                .build();
    }
}
