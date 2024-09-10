package org.example.strategie01;

public class Main {

    public static void main(String[] args) {
        SimulateurTax simulateurTax = new SimulateurTax(35000);

        simulateurTax.calculateTax(new ImpotProgressifStrategy());
        simulateurTax.calculateTax(new ImpotForfaitaireStrategy(1000));
        simulateurTax.calculateTax(new TVAStrategy(21));


    }

}
