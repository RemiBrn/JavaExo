package org.example.strategie01;

public class SimulateurTax {
    private double income;

    public SimulateurTax(double income) {
        this.income = income;
    }

    public void calculateTax(TaxStrategy taxStrategy ) {
        System.out.println(taxStrategy.calculateTax(income));
    }

}
