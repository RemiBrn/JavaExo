package org.example.exo02zoo.Util;

import org.example.exo02zoo.DAO.AnimalDAO;
import org.example.exo02zoo.Entity.Animal;
import org.example.exo02zoo.Entity.Repas;
import org.example.exo02zoo.DAO.RepasDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private Scanner scanner;
    private AnimalDAO animalDAO;
    private RepasDAO repasDAO;

    public Ihm(Connection connection) {
        scanner = new Scanner(System.in);
        animalDAO = new AnimalDAO(connection);
        repasDAO = new RepasDAO();
    }

//    public void start() {
//        String entry;
//        while (true) {
//            showMenu();
//            entry = scanner.nextLine();
//            switch (entry) {
//                case "1" -> createAnimal();
//                case "2" -> showAllAnimals();
//                case "3" -> searchAnimals();
//                case "4" -> addRepas();
//                case "0" -> {
//                    System.out.println("Fermeture de l'application. \nAu revoir ! ");
//                    return;
//                }
//
//                default -> System.out.println("Choix invalide, réessayez");
//            }
//        }
//    }

    public void start() {
        String entry;
        while (true) {
            showMenu();
            entry = scanner.nextLine();
            try {
                switch (entry) {
                    case "1" -> createAnimal();
                    case "2" -> showAllAnimals();
                    case "3" -> searchAnimals();
                    case "4" -> addRepas(); // L'exception est capturée ici
                    case "0" -> {
                        System.out.println("Fermeture de l'application. \nAu revoir !");
                        return;
                    }
                    default -> System.out.println("Choix invalide, réessayez");
                }
            } catch (SQLException e) {
                System.out.println("Une erreur s'est produite lors de l'enregistrement du repas : " + e.getMessage());
            }
        }
    }


    private void showMenu() {
        System.out.println("""
                \n---- Zoo Management ----
                1/ Ajouter un animal
                2/ Afficher tous les animaux
                3/ Chercher un animal
                4/ Enregistrer un repas
                0/ Quitter
                """);
    }

    private void createAnimal() {
        System.out.println("--- Ajouter un animal ---");

        System.out.print("Nom: ");
        String name = scanner.nextLine();

        System.out.print("Race: ");
        String race = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Habitat: ");
        String habitat = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Animal animal = Animal.builder()
                .nom(name)
                .race(race)
                .description(description)
                .habitat(habitat)
                .age(age)
                .build();

        animalDAO.addAnimal(animal);
        System.out.println("Animal ajouté: " + animal);
    }

    private void showAllAnimals() {
        System.out.println("--- Liste de tous les animaux ---");
        List<Animal> animals = animalDAO.getAllAnimals();
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private void searchAnimals() {
        System.out.println("--- Chercher un animal ---");

        System.out.print("Nom (ou appuyez sur Enter pour passer): ");
        String name = scanner.nextLine();

        System.out.print("Race (ou appuyez sur Enter pour passer): ");
        String race = scanner.nextLine();

        System.out.print("Habitat (ou appuyez sur Enter pour passer): ");
        String habitat = scanner.nextLine();

        System.out.print("Age (ou appuyez sur Enter pour passer): ");
        String ageStr = scanner.nextLine();
        Integer age = ageStr.isEmpty() ? null : Integer.parseInt(ageStr);

        List<Animal> animals = animalDAO.getAllAnimalsBy(name, race, habitat, age);
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private void addRepas() throws SQLException {
        System.out.println("--- Ajouter un repas ---");


        // Collecte des informations pour chaque champ de la classe Repas
        System.out.print("Id de l'animal: ");
        int animalID = scanner.nextInt();
        scanner.nextLine();  // Consommer le retour à la ligne

        System.out.print("Race de l'animal: ");
        String race = scanner.nextLine();

        System.out.print("Id du gardien: ");
        int gardienID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Date du repas (format: yyyy-MM-dd): ");
        String dateRepasStr = scanner.nextLine();
        LocalDate dateRepas = LocalDate.parse(dateRepasStr); // Conversion de la chaîne en LocalDate

        System.out.print("Heure du repas (format: HH:mm:ss): ");
        String heureRepasStr = scanner.nextLine();
        LocalTime heureRepas = LocalTime.parse(heureRepasStr); // Conversion de la chaîne en LocalTime

        System.out.print("Détails de la nourriture: ");
        String detailsNourriture = scanner.nextLine();

        // Construction d'un objet Repas avec les valeurs saisies
        Repas repas = Repas.builder()
                .animalId(animalID)
                .raceAnimal(race)
                .gardienId(gardienID)
                .dateRepas(dateRepas)
                .heureRepas(heureRepas)
                .detailsNourriture(detailsNourriture)
                .build();

        // Insertion du repas dans la base de données
        repasDAO.saveRepas(repas);
        System.out.println("Repas ajouté: " + repas);
    }


//    private void deleteAnimal() {
//        System.out.println("--- Delete animal ---");
//
//        showAllAnimals();
//
//        System.out.print("ID of the animal to delete: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();  // Consume newline
//
//        // Assuming a delete method exists in AnimalDAO
//        if (animalDAO.deleteAnimal(id)) {
//            System.out.println("Animal deleted successfully.");
//        } else {
//            System.out.println("Error during deletion.");
//        }
//    }
}
