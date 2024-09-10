package org.example;

//import org.example.controller.IHM;

import org.example.entity.Client;
import org.example.entity.Vente;
import org.example.entity.product.Article;
import org.example.repository.ArticleRepository;
import org.example.util.SessionFactorySingleton;
import org.example.util.StatusVente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
//        IHM ihm = new IHM();
//        ihm.start();

//        SessionFactorySingleton sessionFactorySingleton = new SessionFactorySingleton();
//        InventaireRepository inventaireRepository = new InventaireRepository();
//
//        inventaireRepository.creat

//        ArticleRepository inventaireRepository = new ArticleRepository();
//        Scanner scanner = new Scanner(System.in);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//        System.out.println("-- Création d'un produit --");
//        System.out.print("Nom du produit : ");
//        String description = scanner.nextLine();
//        System.out.print("Prix du produit : ");
//        float prix = Float.parseFloat(scanner.nextLine());
//
//        System.out.print("Quantité en stock : ");
//        int quantiteEnStock = scanner.nextInt();
//        scanner.nextLine();  // Consomme la nouvelle ligne
//        System.out.print("Date de restock (jj/MM/aaaa) : ");
//        String dateRestockStr = scanner.nextLine();
//
//        try {
//            Date dateRestock = dateFormat.parse(dateRestockStr);
//
//            Article article = Article.builder()
//                    .description(description)
//                    .prix(prix)
//                    .quantiteEnStock(quantiteEnStock)
//                    .dateRestock(dateRestock)
//                    .build();
//
//            inventaireRepository.createOrUpdate(article);
//            System.out.println("Produit ajouté avec succès !");
//        } catch (ParseException e) {
//            System.out.println("Format de date invalide. Veuillez utiliser le format jj/MM/aaaa.");
//        } finally {
//            scanner.close();
//        }
//
//        // Fermeture de la session factory lorsque l'application se termine
//        SessionFactorySingleton.closeSessionFactory();


        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Client client = Client.builder().nom("McFly").prenom("Marty").email("martymac@email.com").build();
        Vente vente = Vente.builder().dateVente(LocalDate.now()).statusVente(StatusVente.FINALIZED).build();

        List<Vente> ventes = new ArrayList<>();
        ventes.add(vente);
        client.setVentesList(ventes);

        session.beginTransaction();
        session.saveOrUpdate(client);
        session.getTransaction().commit();

    }

}