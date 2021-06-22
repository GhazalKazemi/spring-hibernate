package com.spring.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestJdbc {

    public static void main(String[] args) {
        Properties properties = new Properties();
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many";
        try {
            properties.load(new FileInputStream("data.properties"));
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection was successful!");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}
