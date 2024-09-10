package org.example.strategie01;

public class TVAStrategy implements TaxStrategy{

    double tvaTaux;

    // Le taux de TVA sera exprimé en %. Exemple : 21

    public TVAStrategy(double tvaTaux) {
        this.tvaTaux = tvaTaux;
    }

    @Override
    public double calculateTax(double income) {
        System.out.println("Montant récoltés sur " + income + " € avec la TVA à " + tvaTaux + "% : " );
        return income * (tvaTaux/100);
    }
}
