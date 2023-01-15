package entity.mapper;

import entity.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LabelMapper {
    public static Label mapRow(ResultSet rs) throws SQLException {
        return Label.newBuilder()
                .setId(rs.getInt("label_id"))
                .setName(rs.getString("label_name"))
                .build();
    }
}
