package org.example.Exo01;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class IHM {
    private Scanner scanner;

    public IHM() {
        this.scanner = new Scanner(System.in);
    }

    public void StartMenu() {
        while (true) {
//            init();
            afficheMenuBase();
            String choix = scanner.nextLine();


            switch (choix) {
                case "1" -> addEtudiant();
                case "2" -> supprimerEtudiant();
                case "3" -> afficherEtudiants();
                case "4" -> afficherEtudiantClasse();
                case "0" -> {
                    System.out.println("Fermeture de l'application. \nAu revoir ! ");
                    return;
                }

                default -> System.out.println("Choix invalide, réessayez");

            }
        }
    }


//        private void init () {
//
//            String url = "jdbc:postgresql://localhost:5432/ExoJDBC?currentSchema=exo01";
//            String username = "postgres";
//            String password = "formation";
//
//        }

    private void afficheMenuBase() {
        System.out.println("""
                \n
                --- Base de données ---
                1/Ajouter un étudiant
                2/Supprimer un étudiant
                3/Afficher tous les étudiants
                4/Afficher les étudiants d'une classe
                0/quitter
                """);
    }

     // Fonction pour ajouter des étudiants

    private void addEtudiant() {
        String url = "jdbc:postgresql://localhost:5432/ExoJDBC?currentSchema=exo01";
        String username = "postgres";
        String password = "formation";
        Connection connection;

        System.out.println("Veuillez entrer votre nom");
        String nomE = scanner.nextLine();
        System.out.println("Veuillez entrer votre Prénom");
        String prenomE = scanner.nextLine();
        System.out.println("Veuillez entrer votre numéro de classe");
        String classeE = scanner.nextLine();
        System.out.println("Veuillez entrer l'année d'obtention de votre diplôme");
        int anneeE = Integer.parseInt(scanner.nextLine());



        try {
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("connexion ok");

                // prepared statement
                Etudiant etudiantCreated = Etudiant.builder()
                        .nom(nomE)
                        .prenom(prenomE)
                        .numClasse(classeE)
                        .anneeDiplome(anneeE).build();

                String requestAdd = "INSERT INTO etudiants (nom,prénom,classe,annee_diplome) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(requestAdd, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, etudiantCreated.getNom());
                preparedStatement.setString(2, etudiantCreated.getPrenom());
                preparedStatement.setString(3, etudiantCreated.getNumClasse());
                preparedStatement.setInt(4, etudiantCreated.getAnneeDiplome());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    etudiantCreated.setId(generatedKeys.getInt(1));
                }

                System.out.println("Etudiant créé avec succès :\n" + etudiantCreated);

//                while(resultSet.next()){
//                    System.out.println(resultSet.getString("title")+" / "+resultSet.getString("author"));
//                }

                connection.close();
            } else {
                System.out.println("connexion échouée");
            }


        } catch (SQLException ex) {
            System.out.println("erreur durant la connection\n" + ex.getMessage());
        }
    }

    // Fonction pour supprimer un étudiant
    private void supprimerEtudiant() {
        String url = "jdbc:postgresql://localhost:5432/ExoJDBC?currentSchema=exo01";
        String username = "postgres";
        String password = "formation";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        System.out.println("Veuillez entrer le nom et le prénom de l'étudiant que vous souhaitez supprimer.\nNom:");
        String nomE = scanner.nextLine();
        System.out.println("Prénom:");
        String prenomE = scanner.nextLine();

        try {
            // Etablir la connexion
            connection = DriverManager.getConnection(url, username, password);


            // Requête SQL pour récupérer tous les étudiants
            String request = "SELECT * FROM etudiants where nom = ? AND prénom = ? ";
            statement = connection.prepareStatement(request);
            statement.setString(1, nomE);
            statement.setString(2, prenomE);


            // Exécuter la requête
            resultSet = statement.executeQuery();
            System.out.println("=== Résultat de la recherche === \n" );

            // Parcourir et afficher chaque étudiant
            while (resultSet.next()) {
                Etudiant etudiant = Etudiant.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .prenom(resultSet.getString("prénom"))
                        .numClasse(resultSet.getString("classe"))
                        .anneeDiplome(resultSet.getInt("annee_diplome"))
                        .build();
                System.out.println(etudiant);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur durant l'exécution de la requête : " + ex.getMessage());
        }

    }




    // Fonction pour afficher tous les étudiants

    private void afficherEtudiants() {
        String url = "jdbc:postgresql://localhost:5432/ExoJDBC?currentSchema=exo01";
        String username = "postgres";
        String password = "formation";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            // Etablir la connexion
            connection = DriverManager.getConnection(url, username, password);

            // Requête SQL pour récupérer tous les étudiants
            String request = "SELECT * FROM etudiants";
            statement = connection.prepareStatement(request);

            // Exécuter la requête
            resultSet = statement.executeQuery();
            System.out.println("=== Liste des étudiants ===\n" );

            // Parcourir et afficher chaque étudiant
            while (resultSet.next()) {
                Etudiant etudiant = Etudiant.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .prenom(resultSet.getString("prénom"))
                        .numClasse(resultSet.getString("classe"))
                        .anneeDiplome(resultSet.getInt("annee_diplome"))
                        .build();
                System.out.println(etudiant);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur durant l'exécution de la requête : " + ex.getMessage());
        }

    }

    // Fonction pour afficher étudiants d'une classe voulue

    private void afficherEtudiantClasse(){
        String url = "jdbc:postgresql://localhost:5432/ExoJDBC?currentSchema=exo01";
        String username = "postgres";
        String password = "formation";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        System.out.println("Veuillez entrer la classe dont vous souhaitez afficher les élèves");
        String classeE = scanner.nextLine();

        try {
            // Etablir la connexion
            connection = DriverManager.getConnection(url, username, password);

            // Requête SQL pour récupérer tous les étudiants
            String request = "SELECT * FROM etudiants where classe = ? ";
            statement = connection.prepareStatement(request);
            statement.setString(1, classeE);

            // Exécuter la requête
            resultSet = statement.executeQuery();
            System.out.println("=== Liste des étudiants ===\n" );

            // Parcourir et afficher chaque étudiant
            while (resultSet.next()) {
                Etudiant etudiant = Etudiant.builder()
                        .id(resultSet.getInt("id"))
                        .nom(resultSet.getString("nom"))
                        .prenom(resultSet.getString("prénom"))
                        .numClasse(resultSet.getString("classe"))
                        .anneeDiplome(resultSet.getInt("annee_diplome"))
                        .build();
                System.out.println(etudiant);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur durant l'exécution de la requête : " + ex.getMessage());
        }






    }



}





