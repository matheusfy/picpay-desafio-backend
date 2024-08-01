package io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.exception;

public class InvalidTransactionValueException extends RuntimeException{

  public InvalidTransactionValueException(String msg){
    super(msg);
  }
}
