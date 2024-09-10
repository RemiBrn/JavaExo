package org.example.adaptateursystempaiement;

public interface OldPaymentGateway {

    public void makePayment(String accountNumber, double amount);
}
