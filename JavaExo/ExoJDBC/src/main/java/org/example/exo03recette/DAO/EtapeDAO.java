package org.example.exo03recette.DAO;

import org.example.exo03recette.Entity.Etape;
import org.example.exo03recette.Util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtapeDAO extends BaseDAO<Etape> {

    @Override
    public Etape create(Etape element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO Etape (description, recette_id) VALUES (?, ?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, element.getDescription());
            statement.setInt(2, element.getRecetteId());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (row != 1) {
                connection.rollback();
                return null;
            }
            if (resultSet.next()) {
                element.setId(resultSet.getInt(1));
            }
            connection.commit();
            return element;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    @Override
    public boolean delete(Etape element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "DELETE FROM Etape WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, element.getId());
            int rowsDeleted = statement.executeUpdate();
            connection.commit();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return false;
        } finally {
            close();
        }
    }

    @Override
    public Etape update(Etape element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "UPDATE Etape SET description = ?, recette_id = ? WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, element.getDescription());
            statement.setInt(2, element.getRecetteId());
            statement.setInt(3, element.getId());
            int rowsUpdated = statement.executeUpdate();
            connection.commit();
            return rowsUpdated > 0 ? element : null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    @Override
    public Etape get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM Etape WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Etape.builder()
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .recetteId(resultSet.getInt("recette_id"))
                        .build();
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            close();
        }
    }

    @Override
    public List<Etape> get() throws SQLException {
        try {
            List<Etape> etapes = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM Etape";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                etapes.add(Etape.builder()
                        .id(resultSet.getInt("id"))
                        .description(resultSet.getString("description"))
                        .recetteId(resultSet.getInt("recette_id"))
                        .build());
            }
            return etapes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            close();
        }
    }
}