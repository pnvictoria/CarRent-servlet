package entity.mapper;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User mapRow(ResultSet rs) throws SQLException {
        return User.newBuilder()
                .setId(rs.getInt("user_id"))
                .setName(rs.getString("user_name"))
                .setSurname(rs.getString("user_surname"))
                .setSex(rs.getBoolean("user_sex"))
                .setDate(rs.getString("user_date"))
                .setEmail(rs.getString("user_email"))
                .setPassword(rs.getString("user_password"))
                .setAvatar(rs.getString("user_avatar"))
                .setRole(RoleMapper.mapRow(rs))
                .build();
    }
}
