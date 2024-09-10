package org.example.exo02zoo.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String url = "jdbc:postgresql://localhost:5432/ExoJDBC?currentSchema=exo02";
    private static final String username = "postgres";
    private static final String password = "formation";

    public static Connection getConnection (){
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            System.out.println("Erreur de connection");
            return null;
        }
    }
}