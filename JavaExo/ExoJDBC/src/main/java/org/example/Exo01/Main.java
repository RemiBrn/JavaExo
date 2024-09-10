package org.example.Exo01;



import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        new IHM().StartMenu();
//        String url = "jdbc:postgresql://localhost:5432/ExoJDBC?currentSchema=exo01";
//        String username = "postgres";
//        String password = "formation";
//
//        Connection connection;
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Veuillez entrer votre nom");
//        String nomE = scanner.nextLine();
//        System.out.println("Veuillez entrer votre Prénom");
//        String prenomE = scanner.nextLine();
//        System.out.println("Veuillez entrer votre numéro de classe");
//        String classeE = scanner.nextLine();
//        System.out.println("Veuillez entrer l'année d'obtention de votre diplôme");
//        int anneeE = Integer.parseInt(scanner.nextLine());
//
//        try{
//            connection = DriverManager.getConnection(url,username,password);
//            if(connection != null){
//                System.out.println("connexion ok");
//
//                // prepared statement
//                Etudiant etudiantCreated = Etudiant.builder()
//                        .nom(nomE)
//                        .prenom(prenomE)
//                        .numClasse(classeE)
//                        .anneeDiplome(anneeE).build();
//
//                String requestAdd = "INSERT INTO etudiants (nom,prénom,classe,annee_diplome) VALUES (?,?,?,?)";
//                PreparedStatement preparedStatement = connection.prepareStatement(requestAdd, Statement.RETURN_GENERATED_KEYS);
//                preparedStatement.setString(1, etudiantCreated.getNom());
//                preparedStatement.setString(2, etudiantCreated.getPrenom());
//                preparedStatement.setString(3, etudiantCreated.getNumClasse());
//                preparedStatement.setInt(4, etudiantCreated.getAnneeDiplome());
//                preparedStatement.executeUpdate();
//
//                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//
//                if(generatedKeys.next()){
//                    etudiantCreated.setId(generatedKeys.getInt(1));
//                }
//
//                System.out.println(etudiantCreated);
//
//
//                // recuperation des données
//                String request = "SELECT * FROM etudiants WHERE id = ?";
//                PreparedStatement statement = connection.prepareStatement(request);
//                statement.setInt(1,2);
//
//                ResultSet resultSet = statement.executeQuery();
//
//                if(resultSet.next()){
//                    Etudiant etudiant = Etudiant.builder()
//                            .id(resultSet.getInt("id"))
//                            .nom(resultSet.getString("nom"))
//                            .prenom(resultSet.getString("prénom"))
//                            .numClasse(resultSet.getString("classe"))
//                            .anneeDiplome(resultSet.getInt("annee_diplome")).build();
//                    System.out.println(etudiant);
//                }
//
//
////                while(resultSet.next()){
////                    System.out.println(resultSet.getString("title")+" / "+resultSet.getString("author"));
////                }
//
//                connection.close();
//            }else{
//                System.out.println("connexion échouée");
//            }
//
//
//
//        }catch (SQLException ex){
//            System.out.println("erreur durant la connection\n"+ ex.getMessage());
//        }
//


    }
}
