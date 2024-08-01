package io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.User;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.account.exception.AccountNotFoundException;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos.TransactionDto;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.enums.AccountProfile;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.exception.InsufficienteBalanceException;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.exception.InvalidTransactionProfileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ValidateSender implements ITransactionValidation{

  private static final Logger logger = LogManager.getLogger();

  @Override
  public void validateTransaction(TransactionDto transactionDto, User receiver, User sender) {

    if (sender.getProfile() == AccountProfile.SHOPKEEPER.getValue()) {
      logger.error("Accounts with a shopkeeper profile are not allowed to perform transfers.");
      throw new InvalidTransactionProfileException("Accounts with a shopkeeper profile are not allowed to perform transfers.");
    }

    if (sender.getAccount() == null){
      logger.error("Sender does not have an active account.");
      throw new AccountNotFoundException("Sender does not have an active account.");
    }

    if (sender.getAccount().getBalance() < transactionDto.value()) {
      logger.error("Inssuficient balance for transaction");
      throw new InsufficienteBalanceException("Inssuficient balance for transaction");
    }
  }
}
