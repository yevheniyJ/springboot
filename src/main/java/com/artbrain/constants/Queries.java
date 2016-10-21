package com.artbrain.constants;

public interface Queries {

  //user table
  String INSERT_NEW_USER = "INSERT INTO users (username, password, role) VALUES (?,?,?);";
  String UPDATE_USER_BY_USERNAME = "UPDATE users SET password=?, role=? WHERE username=?;";
  String DELETE_USER_BY_USERNAME = "DELETE FROM users WHERE username=?;";
  String LOAD_ALL_USERS = "SELECT*FROM users;";
  String LOAD_USER_BY_USERNAME = "SELECT*FROM users WHERE username=?;";

}
