package io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.User;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public interface ITransactionValidation {

  public void validateTransaction(TransactionDto transactionDto, User receiver, User sender);
}
