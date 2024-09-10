//package org.example.controller;
//
//import org.example.util.SessionFactorySingleton;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import java.util.Scanner;
//
//public class IHM {
//    private SessionFactorySingleton sessionFactory;
//    private Scanner sc;
//
//    public IHM() {
//        sc = new Scanner(System.in);
//    }
//
//    public void start() {
//        int entry;
//        while (true) {
//            System.out.println("--- Application de Gestion ---");
//            System.out.println("1/ Inventaire");
//            System.out.println("2/ Housing Product");
//            System.out.println("3/ Electronic Product");
//            entry = sc.nextInt();
//            sc.nextLine();
//
//            switch (entry) {
//                case 1:
//                    InventaireIHM.start();
//                    break;
//                case 2:
//
//                    break;
//                case 3:
//
//                    break;
//
//                case 0:
//                    return;
//
//                default:
//                    System.out.println("Option invalide. Veuillez réessayer");
//            }
//        }
//
//    }
//
//}