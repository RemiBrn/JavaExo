package org.example.observer01;

public class StockManager implements Observer {


    @Override
    public void update(int stockLevel) {
        System.out.println("[Stock Manager] Le niveau de stock a changé. Niveau actuel : " + stockLevel);
    }

}
