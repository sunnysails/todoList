package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static String DRIVER;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        //加载并读取config.properties文件
        Properties prop = new Properties();
        try {
            prop.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
            DRIVER = prop.getProperty("jdbc.driver");
            URL = prop.getProperty("jdbc.url");
            USERNAME = prop.getProperty("jdbc.username");
            PASSWORD = prop.getProperty("jdbc.password");
        } catch (IOException e) {
            throw new DataAccessException("读取config.properties文件异常", e);
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
