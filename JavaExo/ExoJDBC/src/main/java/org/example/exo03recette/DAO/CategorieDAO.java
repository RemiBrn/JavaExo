package org.example.exo03recette.DAO;

import org.example.exo03recette.Entity.Categorie;
import org.example.exo03recette.Util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO extends BaseDAO<Categorie> {

    @Override
    public Categorie create(Categorie element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO Categorie (nom) VALUES (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, element.getNom());
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
    public boolean delete(Categorie element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "DELETE FROM Categorie WHERE id = ?";
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
    public Categorie update(Categorie element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "UPDATE Categorie SET nom = ? WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setString(1, element.getNom());
            statement.setInt(2, element.getId());
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
    public Categorie get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM Categorie WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Categorie.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
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
    public List<Categorie> get() throws SQLException {
        try {
            List<Categorie> categories = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM Categorie";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                categories.add(Categorie.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .build());
            }
            return categories;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            close();
        }
    }
}
