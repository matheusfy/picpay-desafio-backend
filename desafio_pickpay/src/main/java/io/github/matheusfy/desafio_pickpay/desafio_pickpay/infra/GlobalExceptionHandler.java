package io.github.matheusfy.desafio_pickpay.desafio_pickpay.infra;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.authorization.exception.NonAuthorizedException;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.account.exception.AccountNotFoundException;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.exception.InsufficienteBalanceException;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.exception.InvalidTransactionProfileException;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.exception.InvalidTransactionValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {


  @ExceptionHandler(AccountNotFoundException.class)
  public ResponseEntity<String> AccountNotFoundException(String msg){
    return ResponseEntity.badRequest().body(msg);
  }

  @ExceptionHandler(InvalidTransactionProfileException.class)
  public ResponseEntity<String> InvalidTransactionProfileException(String msg){
    return ResponseEntity.badRequest().body(msg);
  }

  @ExceptionHandler(InvalidTransactionValueException.class)
  public ResponseEntity<String> InvalidTransactionValueException(String msg){
    return ResponseEntity.badRequest().body(msg);
  }

  @ExceptionHandler(InsufficienteBalanceException.class)
  public ResponseEntity<String> InsufficienteBalanceException(String msg){
    return ResponseEntity.badRequest().body(msg);
  }

  @ExceptionHandler(NonAuthorizedException.class)
    public ResponseEntity<String> NonAuthorizedException(String msg){
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(msg);
  }
}
