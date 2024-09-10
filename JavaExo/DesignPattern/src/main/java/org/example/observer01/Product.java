package org.example.observer01;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private List<Observer> observers;
    private int stockLevel;

    public Product(int stockLevel) {
        this.observers = new ArrayList<>();
        this.stockLevel = stockLevel;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockLevel);
        }
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public int getStockLevel() {
        return stockLevel;
    }

}
