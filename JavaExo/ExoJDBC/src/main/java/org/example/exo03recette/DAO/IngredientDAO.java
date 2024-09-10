package org.example.exo03recette.DAO;

import org.example.exo03recette.Entity.Ingredient;
import org.example.exo03recette.Util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO extends BaseDAO<Ingredient> {

    @Override
    public Ingredient create(Ingredient element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO Ingredient (nom) VALUES (?)";
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
    public boolean delete(Ingredient element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "DELETE FROM Ingredient WHERE id = ?";
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
    public Ingredient update(Ingredient element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "UPDATE Ingredient SET nom = ? WHERE id = ?";
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
    public Ingredient get(int id) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM Ingredient WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Ingredient.builder()
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
    public List<Ingredient> get() throws SQLException {
        try {
            List<Ingredient> ingredients = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM Ingredient";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingredients.add(Ingredient.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .build());
            }
            return ingredients;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } finally {
            close();
        }
    }

    public List<Ingredient> search(String searchValue, String value) throws SQLException {
        try {
            List<Ingredient> ingredients = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            switch (searchValue) {
                default:
                    request = "SELECT * FROM Ingredient WHERE " + searchValue + " LIKE ?";
                    value = "%" + value + "%";
                    break;
            }
            statement = connection.prepareStatement(request);
            statement.setString(1, value);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingredients.add(Ingredient.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .build());
            }
            return ingredients;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }
}
