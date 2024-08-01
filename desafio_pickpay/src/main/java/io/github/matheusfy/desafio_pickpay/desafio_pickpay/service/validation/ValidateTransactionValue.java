package io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.User;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos.TransactionDto;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.exception.InvalidTransactionValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ValidateTransactionValue implements ITransactionValidation{

  private static final Logger logger = LogManager.getLogger();


  @Override
  public void validateTransaction(TransactionDto transactionDto, User receiver, User sender) {
    if (transactionDto.value() <= 0) {
      logger.error("Transaction value can't be bellow than zero.");
      throw new InvalidTransactionValueException("Transaction value can't be bellow than zero.");
    }
  }
}
