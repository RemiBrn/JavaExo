package org.example.strategie01;

public class ImpotProgressifStrategy implements TaxStrategy {

    @Override
    public double calculateTax(double income) {
        double tax = 0;

        if (income <= 10000) {
            tax = income * 0.10;
        } else if (income <= 30000) {
            tax = 10000 * 0.10 + (income - 10000) * 0.20;
        } else {
            tax = 10000 * 0.10 + 20000 * 0.20 + (income - 30000) * 0.30;
        }
        System.out.println("Montant récoltés sur " + income + "€ avec l'impôt progressif : " );
        return tax;
    }
}
