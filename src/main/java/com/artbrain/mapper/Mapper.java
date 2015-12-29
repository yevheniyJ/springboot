package com.artbrain.mapper;

import com.artbrain.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {

  private Mapper(){}

  public static User mapUser(ResultSet rs, int rowNum) throws SQLException {
    User user = new User();
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setRole(rs.getString("role"));
    return user;
  }

}
