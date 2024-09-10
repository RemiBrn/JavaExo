package org.example.exo02zoo.DAO;

import org.example.exo02zoo.Util.DatabaseManager;
import org.example.exo02zoo.Entity.Repas;

import java.sql.*;
import java.time.LocalDate;

public class RepasDAO {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private String request;

    public RepasDAO() {
        this.connection = DatabaseManager.getConnection();
    }


    public Repas saveRepas(Repas repas) throws SQLException {
        try {
            // Préparation de la requête SQL pour insérer un nouveau repas
            request = "INSERT INTO repas (animal_id, race_animal, gardien_id, date_repas, heure_repas, details_nourriture) " +
                    "VALUES (?,?,?,?,?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);

            // Remplissage des paramètres de la requête SQL avec les valeurs de l'objet Repas
            statement.setInt(1, repas.getAnimalId());
            statement.setString(2, repas.getRaceAnimal());
            statement.setInt(3, repas.getGardienId());
            statement.setDate(4, Date.valueOf(repas.getDateRepas()));
            statement.setTime(5, Time.valueOf(repas.getHeureRepas()));
            statement.setString(6, repas.getDetailsNourriture());

            // Exécution de la requête
            statement.executeUpdate();

            // Récupération de l'ID généré (si nécessaire) et mise à jour de l'objet Repas
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                repas.setId(resultSet.getInt(1));
            }
            connection.commit();

            return repas; // Retourne l'objet Repas avec l'ID mis à jour

        } catch (SQLException e) {
            // Affichage d'un message d'erreur en cas d'exception SQL
            System.out.println(e.getMessage());
            return null;

        } finally {
            try {
                // Fermeture des ressources
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
    }



}
