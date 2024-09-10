package org.example.observer01;

public class Supplier implements Observer {

    @Override
    public void update(int stockLevel) {
        System.out.println("[Supplier] Le niveau de stock a changé. Niveau actuel : " + stockLevel);
    }

}
