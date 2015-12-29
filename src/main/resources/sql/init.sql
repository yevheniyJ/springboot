create database `spring_boot` DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
  USE spring_boot;
CREATE TABLE IF NOT EXISTS users (username VARCHAR(255) NOT NULL PRIMARY KEY, password VARCHAR(255) NOT NULL, role VARCHAR(255) NOT NULL);
