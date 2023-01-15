package entity.mapper;

import entity.Level;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LevelMapper {
    public static Level mapRow(ResultSet rs) throws SQLException {
        return Level.newBuilder()
                .setId(rs.getInt("level_id"))
                .setName(rs.getString("level_name"))
                .build();
    }
}
