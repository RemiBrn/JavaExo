package org.example.adaptateursystempaiement;

public  class PaymentAdapter implements OldPaymentGateway{
    private NewPaymentProcessor newPaymentProcessor;
    private String apiKey;

    // Constructeur qui prend une API Key pour l'authentification
    public PaymentAdapter(String apiKey) {
        this.newPaymentProcessor = new NewPaymentProcessor();
        this.apiKey = apiKey;
        this.newPaymentProcessor.authenticate(this.apiKey);
    }


    @Override
    public void makePayment(String accountNumber, double amount) {
        System.out.println("Traitement du paiement pour le compte: " + accountNumber);
        newPaymentProcessor.sendPayment(amount);

    }

}
