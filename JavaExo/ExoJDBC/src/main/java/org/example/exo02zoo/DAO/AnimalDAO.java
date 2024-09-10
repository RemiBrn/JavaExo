package org.example.exo02zoo.DAO;

import org.example.exo02zoo.Entity.Animal;
import org.example.exo02zoo.Util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;

    public AnimalDAO(Connection connection) {
        this.connection = connection;
    }

    public Animal addAnimal(Animal animal) {
        try {
            request = "INSERT INTO animaux (nom,race,description,habitat,age) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, animal.getNom());
            statement.setString(2, animal.getRace());
            statement.setString(3, animal.getDescription());
            statement.setString(4, animal.getHabitat());
            statement.setInt(5, animal.getAge());

            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                animal.setId(resultSet.getInt(1));
            }
            // Valider les changements
            connection.commit();

            return animal;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                request = null;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Animal> getAllAnimals(){
        try{
            List<Animal> animals = new ArrayList<>();
            request = "SELECT * FROM animaux";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                animals.add(Animal.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .race(resultSet.getString("race"))
                        .description(resultSet.getString("description"))
                        .habitat(resultSet.getString("habitat"))
                        .age(resultSet.getInt("age"))
                        .build()
                );
            }

            return animals;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            try{
                if(statement!= null && !statement.isClosed()){
                    statement.close();
                }
                if(resultSet != null && !resultSet.isClosed()){
                    resultSet.close();
                }
                request = null;
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Animal> getAllAnimalsBy(String nom, String race, String habitat, Integer age) {
        List<Animal> animals = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM animaux WHERE 1=1");

        if (nom != null && !nom.isEmpty()) {
            queryBuilder.append(" AND nom = ?");
        }
        if (race != null && !race.isEmpty()) {
            queryBuilder.append(" AND race = ?");
        }
        if (habitat != null && !habitat.isEmpty()) {
            queryBuilder.append(" AND habitat = ?");
        }
        if (age != null) {
            queryBuilder.append(" AND age = ?");
        }

        try {
            statement = connection.prepareStatement(queryBuilder.toString());

            int paramIndex = 1;

            if (nom != null && !nom.isEmpty()) {
                statement.setString(paramIndex++, nom);
            }
            if (race != null && !race.isEmpty()) {
                statement.setString(paramIndex++, race);
            }
            if (habitat != null && !habitat.isEmpty()) {
                statement.setString(paramIndex++, habitat);
            }
            if (age != null) {
                statement.setInt(paramIndex++, age);
            }

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                animals.add(Animal.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .race(resultSet.getString("race"))
                        .description(resultSet.getString("description"))
                        .habitat(resultSet.getString("habitat"))
                        .age(resultSet.getInt("age"))
                        .build()
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return animals;
    }






}



