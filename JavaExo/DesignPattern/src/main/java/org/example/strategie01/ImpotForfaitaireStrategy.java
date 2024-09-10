package org.example.strategie01;

public class ImpotForfaitaireStrategy implements TaxStrategy{
    double taxForfait;
    public ImpotForfaitaireStrategy(double taxForfait) {
        this.taxForfait = taxForfait;
    }


    @Override
    public double calculateTax(double income){
              System.out.println("Montant récoltés sur " + income + "€ avec l'impôt forfaitaire à " + taxForfait + "€ : " );
        return taxForfait;

    }

}
