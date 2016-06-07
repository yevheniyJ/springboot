package com.artbrain.mapper;

import com.artbrain.entity.User;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class Mapper {

  public User mapUser(ResultSet rs, int rowNum) throws SQLException {
    User user = new User();
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setRole(rs.getString("role"));
    return user;
  }

}
