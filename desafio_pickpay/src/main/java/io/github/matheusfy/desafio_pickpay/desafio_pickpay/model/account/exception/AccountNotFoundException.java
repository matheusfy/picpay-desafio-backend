package io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.account.exception;

public class AccountNotFoundException extends RuntimeException{

  public AccountNotFoundException(String msg){
    super(msg);
  }
}
