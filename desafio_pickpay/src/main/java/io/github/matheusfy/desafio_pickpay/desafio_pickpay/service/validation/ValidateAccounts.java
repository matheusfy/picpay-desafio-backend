package io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.User;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.account.exception.AccountNotFoundException;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos.TransactionDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ValidateAccounts implements ITransactionValidation{

  private static final Logger logger = LogManager.getLogger();

  @Override
  public void validateTransaction(TransactionDto transactionDto, User receiver, User sender) {

    if (receiver == null) {
      logger.error("Receiver not found.");

      throw new AccountNotFoundException("Receiver not found.");
    }

    if (sender == null) {
      logger.error("Sender not found.");
      throw new AccountNotFoundException("Sender not found.");
    }
  }
}
