package org.example.adaptateursystempaiement;

public class NewPaymentProcessor {
    private String apiKey;


    public void authenticate(String apiKey){
        this.apiKey = apiKey;
        System.out.println("N° authentification : " + apiKey);

    }

    public void sendPayment(double amount){
        System.out.println("Paiement de : " + amount +" €");
    }



}
