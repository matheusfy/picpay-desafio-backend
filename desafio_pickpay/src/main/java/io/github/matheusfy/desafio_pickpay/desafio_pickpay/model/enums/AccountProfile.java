package io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.enums;

public enum AccountProfile {

  COMUM(1), SHOPKEEPER(2);

  private final int value;

  private AccountProfile(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
