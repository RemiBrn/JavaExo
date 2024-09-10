package org.example.adapteur02;

public class Service {
    public static void main(String[] args) {
        SmsService sms = new NotificationAdapter();

        sms.sendSms("0487963252", "Vous êtes viré ! ");

        EmailService emailService = new EmailService();
        emailService.sendEmail("545454@gmail.com", "Stage", "You're fired, Mac Fly !");
    }
}
