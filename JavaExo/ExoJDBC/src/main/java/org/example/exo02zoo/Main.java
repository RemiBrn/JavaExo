package org.example.exo02zoo;

import org.example.exo02zoo.DAO.AnimalDAO;
import org.example.exo02zoo.Entity.Animal;
import org.example.exo02zoo.Util.DatabaseManager;

import java.sql.Connection;
import org.example.exo02zoo.Util.Ihm;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = DatabaseManager.getConnection();
        if (connection != null) {
            Ihm ihm = new Ihm(connection);
            ihm.start();
        } else {
            System.out.println("Unable to establish database connection.");
        }



    }
}
