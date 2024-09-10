//package org.example;
//
//import java.sql.*;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        String url = "jdbc:postgresql://localhost:5432/";
//        String username = "postgres";
//        String password = "formation";
//
//        Connection connection;
//
//        try {
//            connection = DriverManager.getConnection(url, username, password);
//            if (connection != null) {
//                System.out.println("connexion ok");
//
////                Statement statement = connection.createStatement();
////                String request = "INSERT INTO BOOK (title, author, publisher, isbn) VALUES ('Fondation', 'Asimov', 'Montblanc', '123456789') ";
////                int nbrRow = statement.executeUpdate(request);
////                if(nbrRow ==1) {
////                    System.out.println("Le livre a bien été ajouté");
////                }
//
//
////                ======= Pour éviter les injections SQL : ===========
//
//                String requestAdd = "INSERT INTO BOOK (title, author, publisher, isbn) VALUES (?,?,?,?)";
//                PreparedStatement preparedStatement = connection.prepareStatement(requestAdd);
//                preparedStatement.setString(1, "1984");
//                preparedStatement.setString(2, "Orwell");
//                preparedStatement.setString(3, "Plomb");
//                preparedStatement.setString(4, "5498451368");
//                preparedStatement.executeUpdate();
//
//                // Récupération des données :
//                Statement statement = connection.createStatement();
//                String request = "Select * from book";
//                ResultSet resultSet = statement.executeQuery(request);
//
//                while (resultSet.next()) {
//                    System.out.println(resultSet.getString("title") + " / " + resultSet.getString("author"));
//                }
//
//                 // ======= Alternative avec la classe Book: ===========
//                Etudiant book = Etudiant.builder()
//                        .nom("Neuromancer")
//                        .prenom("William Gibson")
//                        .publisher("Lombok")
//                        .isbn("0100101020110").build();
//
//                String requestAdd = "INSERT INTO BOOK (title, author, publisher, isbn) VALUES (?,?,?,?)";
//                PreparedStatement preparedStatement = connection.prepareStatement(requestAdd);
//                preparedStatement.setString(1,  book.getNom());
//                preparedStatement.setString(2, book.getPrenom());
//                preparedStatement.setString(3, book.getPrenom());
//                preparedStatement.setString(4,  book.getIsbn());
//                preparedStatement.executeUpdate();
//
//                connection.close();
//            } else {
//                System.out.println("connexion échouée");
//            }
//
//
//        } catch (SQLException ex) {
//            System.out.println("erreur durant la connexion\n" + ex.getMessage());
//        }
//
//
//    }
//
//}