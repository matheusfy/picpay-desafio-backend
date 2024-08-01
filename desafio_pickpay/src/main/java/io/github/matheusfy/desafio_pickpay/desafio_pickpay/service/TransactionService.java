package io.github.matheusfy.desafio_pickpay.desafio_pickpay.service;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.authorization.AuthorizationService;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.Transaction;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.User;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos.TransactionDto;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.notification.NotificationService;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.repository.TransactionRepository;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.repository.UserRepository;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.validation.ITransactionValidation;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService {

  private static final Logger logger = LogManager.getLogger();

  UserRepository userRepository;
  TransactionRepository transactionRepository;
  AuthorizationService authorizationService;
  NotificationService notificationService;
  private final List<ITransactionValidation> validations;


  public TransactionService(UserRepository userRepository, TransactionRepository transactionRepository,
                            AuthorizationService authorizationService, NotificationService notificationService, List<ITransactionValidation> validations) {
    this.userRepository = userRepository;
    this.transactionRepository = transactionRepository;
    this.authorizationService = authorizationService;
    this.notificationService = notificationService;
    this.validations = validations;
  }

  @Transactional
  public void transfer(TransactionDto transactionDto) {

    User sender = getUser(transactionDto.senderId());
    User receiver = getUser(transactionDto.receiverId());

    validations.forEach(validation -> {
      validation.validateTransaction(transactionDto, receiver, sender);
    });

    logger.info("Iniciando transação: " + transactionDto);
    authorizationService.authorize();


    Transaction transaction = new Transaction(transactionDto);

    try{
      transaction = transactionRepository.save(transaction);
    } catch (Error e){
      // failed to save transaction to DB
      // TODO: Add transaction do save pendent list
      // 1. Salva em um arquivo utilizando uma thread separada que vai ficar realizando a verificação se existe um arquivo de registros pendentes ou
      // 2. manda pra um serviço que vai tentar salvar depois o registro de transação
    }

    sender.getAccount().debit(transaction.getValue());
    receiver.getAccount().credit(transaction.getValue());

    logger.info("Sender updated balance: " + sender + "; Receiver updated balance: " + receiver);

//    notificationService.notify(transaction);
  }

  public User getUser(long id) {
    return userRepository.findById(id).orElse(null);
  }

}
