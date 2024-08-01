package io.github.matheusfy.desafio_pickpay.desafio_pickpay.notification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.Transaction;


@Service
public class NotificationProducer {

  public final KafkaTemplate<String, Transaction> kafkaTemplate;
  public static final Logger logger = LogManager.getLogger();

  public NotificationProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendNotification(Transaction transaction) {
    logger.info("Sending transaction notification.");
    kafkaTemplate.send("transaction-notification", transaction);
  }
}
