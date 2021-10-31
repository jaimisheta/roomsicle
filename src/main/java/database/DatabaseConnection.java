package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String URL = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_24_DEVINT";
    String USER = "CSCI5308_24_DEVINT_USER";
    String PASSWORD = "pa6aechaLohd0aik";

    public Connection getConnectionObject(){
        Connection connection = null;
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL,USER, PASSWORD);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
