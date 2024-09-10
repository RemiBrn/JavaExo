package org.example.adapteur02;

public class NotificationAdapter implements SmsService {
    private EmailService emailService;

    public NotificationAdapter() {
        emailService = new EmailService();
    }

    @Override
    public void sendSms(String phoneNumber, String message) {
        emailService.sendEmail(phoneNumber, " ",message);
    }

}

