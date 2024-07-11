package io.github.matheusfy.desafio_pickpay.desafio_pickpay.notification;

public record TransactionNotification(
    String status,
    MessageRec data) {
  public boolean success() {
    return status.equals("fail") ? false : true;
  }
}
