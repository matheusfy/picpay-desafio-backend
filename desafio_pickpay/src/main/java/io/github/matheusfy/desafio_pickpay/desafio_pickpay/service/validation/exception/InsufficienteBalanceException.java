package io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.exception;

public class InsufficienteBalanceException extends RuntimeException{

  public InsufficienteBalanceException(String msg){
    super(msg);
  }
}
