package org.example.exo03recette.DAO;

import org.example.exo03recette.Entity.Recette;
import org.example.exo03recette.Entity.Ingredient;
import org.example.exo03recette.Entity.Etape;
import org.example.exo03recette.Entity.Commentaire;
import org.example.exo03recette.Entity.Categorie;
import org.example.exo03recette.Util.DatabaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAO extends BaseDAO{
    @Override
    public Recette create(Recette element) throws SQLException {
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO Recette (nom, temps_prep, temps_cuisson, difficulte, categorie_id) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, element.getNom());
            statement.setInt(2, element.getTempsPrep());
            statement.setInt(3, element.getTempsCuisson());
            statement.setString(4, element.getDifficulte());
            statement.setInt(5, element.getCategorie().getId());

            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (row != 1) {
                connection.rollback();
                return null;
            }
            if (resultSet.next()) {
                int recetteId = resultSet.getInt(1);

                // Sauvegarde des ingrédients associés
                saveIngredients(element.getIngredients(), recetteId);

                // Sauvegarde des étapes associées
                saveEtapes(element.getEtapes(), recetteId);

                // Sauvegarde des commentaires associés
                saveCommentaires(element.getCommentaires(), recetteId);
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
    public Recette create(Recette element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Recette element) throws SQLException {
        return false;
    }

    @Override
    public Recette update(Recette element) throws SQLException {
        return null;
    }

    @Override
    public Recette get(int id) throws SQLException {
        return null;
    }

    @Override
    public List get() throws SQLException {
        return List.of();
    }
}


//public class RecetteDAO extends BaseDAO<Recette> {
//
//    @Override
//    public Recette create(Recette element) throws SQLException {
//        try {
//            connection = DatabaseManager.getConnection();
//            request = "INSERT INTO Recette (nom, temps_prep, temps_cuisson, difficulte, categorie_id) VALUES (?, ?, ?, ?, ?)";
//            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
//            statement.setString(1, element.getNom());
//            statement.setInt(2, element.getTempsPrep());
//            statement.setInt(3, element.getTempsCuisson());
//            statement.setString(4, element.getDifficulte());
//            statement.setInt(5, element.getCategorie().getId());
//
//            int row = statement.executeUpdate();
//            resultSet = statement.getGeneratedKeys();
//            if (row != 1) {
//                connection.rollback();
//                return null;
//            }
//            if (resultSet.next()) {
//                int recetteId = resultSet.getInt(1);
//
//                // Sauvegarde des ingrédients associés
//                saveIngredients(element.getIngredients(), recetteId);
//
//                // Sauvegarde des étapes associées
//                saveEtapes(element.getEtapes(), recetteId);
//
//                // Sauvegarde des commentaires associés
//                saveCommentaires(element.getCommentaires(), recetteId);
//            }
//            connection.commit();
//            return element;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            connection.rollback();
//            return null;
//        } finally {
//            close();
//        }
//    }
//
//    private void saveIngredients(List<Ingredient> ingredients, int recetteId) throws SQLException {
//        if (ingredients != null) {
//            String ingredientRequest = "INSERT INTO Recette_Ingredient (recette_id, ingredient_id) VALUES (?, ?)";
//            for (Ingredient ingredient : ingredients) {
//                PreparedStatement ingredientStatement = connection.prepareStatement(ingredientRequest);
//                ingredientStatement.setInt(1, recetteId);
//                ingredientStatement.setInt(2, ingredient.getId());
//                ingredientStatement.executeUpdate();
//                ingredientStatement.close();
//            }
//        }
//    }
//
//    private void saveEtapes(List<Etape> etapes, int recetteId) throws SQLException {
//        if (etapes != null) {
//            String etapeRequest = "INSERT INTO Etape (description, recette_id) VALUES (?, ?)";
//            for (Etape etape : etapes) {
//                PreparedStatement etapeStatement = connection.prepareStatement(etapeRequest);
//                etapeStatement.setString(1, etape.getDescription());
//                etapeStatement.setInt(2, recetteId);
//                etapeStatement.executeUpdate();
//                etapeStatement.close();
//            }
//        }
//    }
//
//    private void saveCommentaires(List<Commentaire> commentaires, int recetteId) throws SQLException {
//        if (commentaires != null) {
//            String commentaireRequest = "INSERT INTO Commentaire (description, recette_id) VALUES (?, ?)";
//            for (Commentaire commentaire : commentaires) {
//                PreparedStatement commentaireStatement = connection.prepareStatement(commentaireRequest);
//                commentaireStatement.setString(1, commentaire.getDescription());
//                commentaireStatement.setInt(2, recetteId);
//                commentaireStatement.executeUpdate();
//                commentaireStatement.close();
//            }
//        }
//    }
//
//    @Override
//    public boolean delete(Recette element) throws SQLException {
//        try {
//            connection = DatabaseManager.getConnection();
//            request = "DELETE FROM Recette WHERE id = ?";
//            statement = connection.prepareStatement(request);
//            statement.setInt(1, element.getId());
//            int rowsDeleted = statement.executeUpdate();
//            connection.commit();
//            return rowsDeleted > 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            connection.rollback();
//            return false;
//        } finally {
//            close();
//        }
//    }
//
//    @Override
//    public Recette update(Recette element) throws SQLException {
//        try {
//            connection = DatabaseManager.getConnection();
//            request = "UPDATE Recette SET nom = ?, temps_prep = ?, temps_cuisson = ?, difficulte = ?, categorie_id = ? WHERE id = ?";
//            statement = connection.prepareStatement(request);
//            statement.setString(1, element.getNom());
//            statement.setInt(2, element.getTempsPrep());
//            statement.setInt(3, element.getTempsCuisson());
//            statement.setString(4, element.getDifficulte());
//            statement.setInt(5, element.getCategorie().getId());
//            statement.setInt(6, element.getId());
//
//            int rowsUpdated = statement.executeUpdate();
//            connection.commit();
//
//            // Mettre à jour les ingrédients, étapes et commentaires associés
//            updateIngredients(element.getIngredients(), element.getId());
//            updateEtapes(element.getEtapes(), element.getId());
//            updateCommentaires(element.getCommentaires(), element.getId());
//
//            return rowsUpdated > 0 ? element : null;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            connection.rollback();
//            return null;
//        } finally {
//            close();
//        }
//    }
//
//    private void updateIngredients(List<Ingredient> ingredients, int recetteId) throws SQLException {
//        // Suppression des anciens ingrédients
//        String deleteIngredients = "DELETE FROM Recette_Ingredient WHERE recette_id = ?";
//        PreparedStatement deleteStatement = connection.prepareStatement(deleteIngredients);
//        deleteStatement.setInt(1, recetteId);
//        deleteStatement.executeUpdate();
//        deleteStatement.close();
//
//        // Ajout des nouveaux ingrédients
//        saveIngredients(ingredients, recetteId);
//    }
//
//    private void updateEtapes(List<Etape> etapes, int recetteId) throws SQLException {
//        // Suppression des anciennes étapes
//        String deleteEtapes = "DELETE FROM Etape WHERE recette_id = ?";
//        PreparedStatement deleteStatement = connection.prepareStatement(deleteEtapes);
//        deleteStatement.setInt(1, recetteId);
//        deleteStatement.executeUpdate();
//        deleteStatement.close();
//
//        // Ajout des nouvelles étapes
//        saveEtapes(etapes, recetteId);
//    }
//
//    private void updateCommentaires(List<Commentaire> commentaires, int recetteId) throws SQLException {
//        // Suppression des anciens commentaires
//        String deleteCommentaires = "DELETE FROM Commentaire WHERE recette_id = ?";
//        PreparedStatement deleteStatement = connection.prepareStatement(deleteCommentaires);
//        deleteStatement.setInt(1, recetteId);
//        deleteStatement.executeUpdate();
//        deleteStatement.close();
//
//        // Ajout des nouveaux commentaires
//        saveCommentaires(commentaires, recetteId);
//    }
//
//    @Override
//    public Recette get(int id) throws SQLException {
//        try {
//            connection = DatabaseManager.getConnection();
//            request = "SELECT * FROM Recette WHERE id = ?";
//            statement = connection.prepareStatement(request);
//            statement.setInt(1, id);
//            resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                // Récupération des ingrédients associés
//                List<Ingredient> ingredients = getIngredients(id);
//
//                // Récupération des étapes associées
//                List<Etape> etapes = getEtapes(id);
//
//                // Récupération des commentaires associés
//                List<Commentaire> commentaires = getCommentaires(id);
//
//                // Récupération de la catégorie associée
//                Categorie categorie = getCategorie(resultSet.getInt("categorie_id"));
//
//                return Recette.builder()
//                        .nom(resultSet.getString("nom"))
//                        .tempsPrep(resultSet.getInt("temps_prep"))
//                        .tempsCuisson(resultSet.getInt("temps_cuisson"))
//                        .difficulte(resultSet.getString("difficulte"))
//                        .ingredients(ingredients)
//                        .etapes(etapes)
//                        .commentaires(commentaires)
//                        .categorie(categorie)
//                        .build();
//            }
//            return null;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        } finally {
//            close();
//        }
//    }
//
//    @Override
//    public List<Recette> get() throws SQLException {
//        try {
//            List<Recette> recettes = new ArrayList<>();
//            connection = DatabaseManager.getConnection();
//            request = "SELECT * FROM Recette";
//            statement = connection.prepareStatement(request);
//            resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                int recetteId = resultSet.getInt("id");
//
//                // Récupération des ingrédients associés
//                List<Ingredient> ingredients = getIngredients(recetteId);
//
//                // Récupération des étapes associées
//                List<Etape> etapes = getEtapes(recetteId);
//
//                // Récupération des commentaires associés
//                List<Commentaire> commentaires = getCommentaires(recetteId);
//
//                // Récupération de la catégorie associée
//                Categorie categorie = getCategorie(resultSet.getInt("categorie_id"));
//
//                recettes.add(Recette.builder()
//                        .nom(resultSet.getString("nom"))
//                        .tempsPrep(resultSet.getInt("temps_prep"))
//                        .tempsCuisson(resultSet.getInt("temps_cuisson"))
//                        .difficulte(resultSet.getString("difficulte"))
//                        .ingredients(ingredients)
//                        .etapes(etapes)
//                        .commentaires(commentaires)
//                        .categorie(categorie)
//                        .build());
//            }
//            return recettes;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return new ArrayList<>();
//        } finally {
//            close();
//        }
//    }
//
//    private List<Ingredient> getIngredients(int recetteId) throws SQLException {
//        List<Ingredient> ingredients = new ArrayList<>();
//        String ingredientRequest = "SELECT i.* FROM Ingredient i JOIN Recette_Ingredient ri ON i.id = ri.ingredient_id WHERE ri.recette_id = ?";
//        PreparedStatement ingredientStatement = connection.prepareStatement(ingredientRequest);
//        ingredientStatement.setInt(1, recetteId);
//        ResultSet ingredientResultSet = ingredientStatement.executeQuery();
//        while (ingredientResultSet.next()) {
//            ingredients.add(Ingredient.builder()
//                    .id(ingredientResultSet.getInt("id"))
//                    .nom(ingredientResultSet.getString("nom"))
//                    .build());
//        }
//        ingredientStatement.close();
//        return ingredients;
//    }
//
//    private List<Etape> getEtapes(int recetteId) throws SQLException {
//        List<Etape> etapes = new ArrayList<>();
//        String etapeRequest = "SELECT * FROM Etape WHERE recette_id = ?";
//        PreparedStatement etapeStatement = connection.prepareStatement(etapeRequest);
//        etapeStatement.setInt(1, recetteId);
//        ResultSet etapeResultSet = etapeStatement.executeQuery();
//        while (etapeResultSet.next()) {
//            etapes.add(Etape.builder()
//                    .id(etapeResultSet.getInt("id"))
//                    .description(etapeResultSet.getString("description"))
//                    .recetteId(recetteId)
//                    .build());
//        }
//        etapeStatement.close();
//        return etapes;
//    }
//
//    private List<Commentaire> getCommentaires(int recetteId) throws SQLException {
//        List<Commentaire> commentaires = new ArrayList<>();
//        String commentaireRequest = "SELECT * FROM Commentaire WHERE recette_id = ?";
//        PreparedStatement commentaireStatement = connection.prepareStatement(commentaireRequest);
//        commentaireStatement.setInt(1, recetteId);
//        ResultSet commentaireResultSet = commentaireStatement.executeQuery();
//        while (commentaireResultSet.next()) {
//            commentaires.add(Commentaire.builder()
//                    .id(commentaireResultSet.getInt("id"))
//                    .description(commentaireResultSet.getString("description"))
//                    .recetteId(recetteId)
//                    .build());
//        }
//        commentaireStatement.close();
//        return commentaires;
//    }
//
//    private Categorie getCategorie(int categorieId) throws SQLException {
//        Categorie categorie = null;
//        String categorieRequest = "SELECT * FROM Categorie WHERE id = ?";
//        PreparedStatement categorieStatement = connection.prepareStatement(categorieRequest);
//        categorieStatement.setInt(1, categorieId);
//        ResultSet categorieResultSet = categorieStatement.executeQuery();
//        if (categorieResultSet.next()) {
//            categorie = Categorie.builder()
//                    .id(categorieResultSet.getInt("id"))
//                    .nom(categorieResultSet.getString("nom"))
//                    .build();
//        }
//        categorieStatement.close();
//        return categorie;
//    }
//}


