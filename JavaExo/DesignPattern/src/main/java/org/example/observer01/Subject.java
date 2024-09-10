package org.example.observer01;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    public void notifyObservers();

}
