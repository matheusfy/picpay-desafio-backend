package io.github.matheusfy.desafio_pickpay.desafio_pickpay.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.client.RestClient;

import jakarta.transaction.Transaction;

public class NotificationConsumer {

  RestClient restClient;

  public NotificationConsumer(RestClient.Builder builder) {
    this.restClient = builder.baseUrl("https://util.devi.tools/api/v1/notify").build();
  }

  @KafkaListener(topics = "transaction-notification")
  public void receiveNotification(Transaction transaction) {
    var response = restClient.get().retrieve().toEntity(TransactionNotification.class);

    if (response.getStatusCode().isError() || !response.getBody().success()) {
      throw new RuntimeException("Falha no envio da notificação");
    }
  }
}
