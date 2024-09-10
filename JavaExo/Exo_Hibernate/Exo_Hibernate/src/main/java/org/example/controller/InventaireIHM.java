//package org.example.controller;
//
//import org.example.entity.Inventaire;
//import org.example.repository.InventaireRepository;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//
//
//public class InventaireIHM {
//
//    private final InventaireRepository inventaireRepository;
//    private final Scanner scanner;
//
//    public InventaireIHM(Scanner scanner) {
//        this.scanner = scanner;
//        this.inventaireRepository = new InventaireRepository();
//    }
//
//    public void start() {
//        int entry;
//
//        while (true) {
//            System.out.println("--- Gestion de l'inventaire ---");
//            System.out.println("1/ Créer un produit");
//            System.out.println("2/ Modifier un produit");
//            System.out.println("3/ Supprimer un produit");
//            System.out.println("4/ Rechercher un produit par ID");
//            System.out.println("5/ Afficher tous les produits");
//            System.out.println("0/ Quitter");
//            System.out.print("Votre choix : ");
//            entry = scanner.nextInt();
//            scanner.nextLine();  // Consomme la nouvelle ligne
//
//            switch (entry) {
//                case 1:
//                    createProduct();
//                    break;
//                case 2:
//                    updateProduct();
//                    break;
//                case 3:
//                    deleteProduct();
//                    break;
//                case 4:
//                    findProductById();
//                    break;
//                case 5:
//                    showAllProducts();
//                    break;
//                case 0:
//                    System.out.println("Au revoir !");
//                    return;
//                default:
//                    System.out.println("Choix invalide, veuillez réessayer.");
//            }
//        }
//    }
//
//    private void createProduct() {
//        System.out.println("-- Création d'un produit --");
//        System.out.print("Nom du produit : ");
//        String description = scanner.nextLine();
//        System.out.print("Prix du produit : ");
//        float prix = scanner.nextFloat();
//        System.out.print("Quantité en stock : ");
//        int quantiteEnStock = scanner.nextInt();
//        scanner.nextLine();  // Consomme la nouvelle ligne
//        System.out.print("Nombre de jours avant restock : ");
//        long days = scanner.nextLong();
//        scanner.nextLine();  // Consomme la nouvelle ligne
//
//        long today = new Date().getTime();
//        today += 86400000 * days;
//        Date dateRestock = new Date(today);
//
//        Inventaire inventaire = Inventaire.builder()
//                .description(description)
//                .prix(prix)
//                .quantiteEnStock(quantiteEnStock)
//                .dateRestock(dateRestock)
//                .build();
//
//        inventaireRepository.createOrUpdate(inventaire);
//        System.out.println("Produit ajouté avec succès !");
//    }
//
//    private void updateProduct() {
//        System.out.println("-- Mise à jour d'un produit --");
//        Inventaire inventaire = findProductByIdInternal();
//        if (inventaire != null) {
//            System.out.print("Nom du produit (" + inventaire.getDescription() + ") : ");
//            String description = scanner.nextLine();
//            if (!description.isEmpty()) inventaire.setDescription(description);
//
//            System.out.print("Prix du produit (" + inventaire.getPrix() + ") : ");
//            String prixInput = scanner.nextLine();
//            if (!prixInput.isEmpty()) inventaire.setPrix(Float.parseFloat(prixInput));
//
//            System.out.print("Quantité en stock (" + inventaire.getQuantiteEnStock() + ") : ");
//            String quantiteInput = scanner.nextLine();
//            if (!quantiteInput.isEmpty()) inventaire.setQuantiteEnStock(Integer.parseInt(quantiteInput));
//
//            System.out.print("Date de restock (" + dateFormat.format(inventaire.getDateRestock()) + ") : ");
//            String dateRestockStr = scanner.nextLine();
//            if (!dateRestockStr.isEmpty()) {
//                try {
//                    Date dateRestock = dateFormat.parse(dateRestockStr);
//                    inventaire.setDateRestock(dateRestock);
//                } catch (ParseException e) {
//                    System.out.println("Format de date invalide. La date précédente sera conservée.");
//                }
//            }
//
//            inventaireRepository.createOrUpdate(inventaire);
//            System.out.println("Produit mis à jour avec succès !");
//        } else {
//            System.out.println("Produit non trouvé !");
//        }
//    }
//
//    private void deleteProduct() {
//        System.out.println("-- Suppression d'un produit --");
//        Inventaire inventaire = findProductByIdInternal();
//        if (inventaire != null) {
//            inventaireRepository.delete(inventaire);
//            System.out.println("Produit supprimé avec succès !");
//        } else {
//            System.out.println("Produit non trouvé !");
//        }
//    }
//
//    private Inventaire findProductByIdInternal() {
//        System.out.print("ID du produit : ");
//        int id = scanner.nextInt();
//        scanner.nextLine();  // Consomme la nouvelle ligne
//        return inventaireRepository.findById(id);
//    }
//
//    private void findProductById() {
//        System.out.println("-- Recherche d'un produit par ID --");
//        Inventaire inventaire = findProductByIdInternal();
//        if (inventaire != null) {
//            System.out.println("Produit trouvé : " + inventaire);
//        } else {
//            System.out.println("Produit non trouvé !");
//        }
//    }
//
//    private void showAllProducts() {
//        System.out.println("-- Affichage de tous les produits --");
//        List<Inventaire> inventaireList = inventaireRepository.getALL();
//        if (inventaireList != null && !inventaireList.isEmpty()) {
//            for (Inventaire inventaire : inventaireList) {
//                System.out.println(inventaire);
//            }
//        } else {
//            System.out.println("Aucun produit trouvé !");
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        InventaireIHM ihm = new InventaireIHM(scanner);
//        ihm.start();
//    }
//}
