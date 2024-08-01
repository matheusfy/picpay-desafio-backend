package io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.exception;

public class InvalidTransactionProfileException extends RuntimeException{

  public InvalidTransactionProfileException(String msg){
    super(msg);
  }
}
