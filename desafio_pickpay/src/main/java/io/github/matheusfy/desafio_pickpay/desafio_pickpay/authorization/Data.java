package io.github.matheusfy.desafio_pickpay.desafio_pickpay.authorization;

public record Data(
    boolean authorization) {
  public boolean isAuthorized() {
    return authorization;
  }
}
