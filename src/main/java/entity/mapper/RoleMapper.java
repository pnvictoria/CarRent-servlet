package entity.mapper;

import entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper {
    public static Role mapRow(ResultSet rs) throws SQLException {
        return Role.newBuilder()
                .setId(rs.getInt("role_id"))
                .setName(rs.getString("role_name"))
                .build();
    }
}
