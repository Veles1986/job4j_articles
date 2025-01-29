package ru.job4j.solid.dip;

class Notification {
private EmailService emailService = new EmailService();

public void sendNotification(String message) {
    emailService.sendEmail(message);
}
}
