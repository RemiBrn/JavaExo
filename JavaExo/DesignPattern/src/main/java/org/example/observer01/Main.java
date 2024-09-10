package org.example.observer01;

public class Main {
    public static void main(String[] args) {

        Product product = new Product(100);

        // Création observateurs
        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier();

        // Enregistrement observateurs
        product.registerObserver(stockManager);
        product.registerObserver(supplier);

        // Modification du niveau de stock
        System.out.println("Modification du niveau de stock à 75...");
        product.setStockLevel(75);

        product.notifyObservers();



    }
}
