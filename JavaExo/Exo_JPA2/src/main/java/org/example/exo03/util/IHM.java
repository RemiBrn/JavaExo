package org.example.exo03.util;

import org.example.exo03.entity.Housing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private Scanner scanner;


    public IHM() {
        scanner = new Scanner(System.in);
    }

    public void startMenu(){
        while(true)
        {
            afficheMenuBase();
            String choix = scanner.nextLine();

            switch (choix){
                case "1" -> creationProduit();
                case "2" -> creationClient();
                case "3" -> effectuerRetrait();
                case "4" -> effectuerDepot();
                case "0" -> {
                    System.out.println("Au revoir !!!");
                    return; // ou break; ou System.exit(0); (termine l'application)

                }
                default -> System.out.println("Choix invalide !");
            }

        }
    }

    private void afficheMenuBase (){
        System.out.println("""
                --- Menu Banque ---
                1/Enregistrer un produit
                2/Voir un produit 
                3/Modifier un produit
                4/Supprimer un produit
                0/quitter
                """);
    }

    private void creationProduit (){
        System.out.println("--- creation d'un produit ---");
        System.out.println("Nom du client :");
        String nom = scanner.nextLine();
        System.out.println("Prenom du client");
        String prenom = scanner.nextLine();
        System.out.println("Email du client :");
        String email = scanner.nextLine();

        clients.add(new Client(nom,prenom,email));
        System.out.println("client crée");
    }

    private void effectuerRetrait (){

        CompteBancaire compte = getCompte("--- effectuer un Retrait---");

        System.out.println("Montant du retrait :");
        double montant = scanner.nextDouble();
        scanner.nextLine();

        compte.retrait(montant);
    }

    private void effectuerDepot (){

        CompteBancaire compte = getCompte("--- effectuer un depot---");

        System.out.println("Montant du depot :");
        double montant = scanner.nextDouble();
        scanner.nextLine();

        compte.depot(montant);
    }

    private void afficherOpperation () {
        CompteBancaire compte = getCompte("--- afficher les opperation ---");
        System.out.println("Operation du compte :");
        for(Operation operation : compte.getOperationList()) {
            System.out.println(operation);
        }
        System.out.println("solde du comptre : "+ compte.getSolde());

    }

    private void listerCompte (){
        System.out.println("--- affichage des compte ---");
        System.out.println("1/ tout les compte");
        System.out.println("2/ compte pour un utilisateur");
        String choix = scanner.nextLine();

        if(choix.equals("1")){
            System.out.println("Tous les compte bancaire :");
            for (Client client : clients){
                for (CompteBancaire compteBancaire : client.getCompteBancaires()){
                    System.out.println(compteBancaire);
                }
            }
        }else{
            System.out.println("Selection un client :");
            for (int i = 0; i< clients.size();i++){
                System.out.println((i+1)+"/ "+clients.get(i).getNom()+" "+clients.get(i).getPrenom());
            }
            int indexClient = scanner.nextInt();
            scanner.nextLine();
            Client client = clients.get(indexClient-1);
            System.out.println("Tous les compte bancaire du client "+client+" :");
            for (CompteBancaire compte : client.getCompteBancaires()){
                System.out.println(compte);
            }
        }
    }
    private CompteBancaire getCompte (String msg){
        System.out.println(msg);
        System.out.println("selectioner client");
        for (int i = 0; i< clients.size();i++){
            System.out.println((i+1)+"/ "+clients.get(i).getNom()+" "+clients.get(i).getPrenom());
        }

        int indexClient = scanner.nextInt();
        scanner.nextLine();
        Client client = clients.get(indexClient-1);

        System.out.println("selectioner Compte");
        for (int i = 0; i< client.getCompteBancaires().size();i++){
            System.out.println((i+1)+"/ "+client.getCompteBancaires().get(i));
        }

        int indexCompte = scanner.nextInt();
        scanner.nextLine();

        return client.getCompteBancaires().get(indexCompte-1);
    }