package io.github.matheusfy.desafio_pickpay.desafio_pickpay.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.Transaction;

@Service
public class NotificationService {

    @Autowired
    NotificationProducer notificationSender;

    public void notify(Transaction transaction) {
        notificationSender.sendNotification(transaction);
    }
}
