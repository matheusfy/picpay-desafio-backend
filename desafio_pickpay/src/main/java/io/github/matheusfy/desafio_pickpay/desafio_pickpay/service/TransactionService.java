package io.github.matheusfy.desafio_pickpay.desafio_pickpay.service;

import org.springframework.stereotype.Service;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.authorization.AuthorizationService;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.Transaction;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.User;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos.TransactionDto;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.enums.AccountProfile;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.notification.NotificationService;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.repository.TransactionRepository;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class TransactionService {

  UserRepository userRepository;
  TransactionRepository transactionRepository;
  AuthorizationService authorizationService;
  NotificationService notificationService;

  public TransactionService(UserRepository userRepository, TransactionRepository transactionRepository,
      AuthorizationService authorizationService, NotificationService notificationService) {
    this.userRepository = userRepository;
    this.transactionRepository = transactionRepository;
    this.authorizationService = authorizationService;
    this.notificationService = notificationService;
  }

  @Transactional
  public void transfer(TransactionDto transactionDto) {

    System.out.println(transactionDto);
    User sender = userRepository.getReferenceById(transactionDto.senderId());
    User receiver = userRepository.getReferenceById(transactionDto.receiverId());
    validateTransaction(transactionDto, receiver, sender);

    System.out.println("Saldo antes encaminhante: " + sender);
    System.out.println("Saldo antes recebedor: " + receiver);
    authorizationService.authorize();

    Transaction transaction = transactionRepository.save(new Transaction(transactionDto));

    // fazer calculos:
    sender.getAccount().debit(transaction.getValue());
    receiver.getAccount().credit(transaction.getValue());

    System.out.println("Saldo depois encaminhante: " + sender);
    System.out.println("Saldo depois recebedor: " + receiver);
    // enviar notificação:

    notificationService.notify(transaction);
  }

  private void validateTransaction(TransactionDto transactionDto, User receiver, User sender) {
    if (transactionDto.value() <= 0) {
      throw new RuntimeException("Valor a enviar precisa ser positivo");
    }

    if (receiver == null) {
      throw new RuntimeException("Recebedor não encontrado");
    }

    if (sender == null) {
      throw new RuntimeException("Enviador não encontrado");
    }

    if (sender.getProfile() == AccountProfile.SHOPKEEPER.getValue()) {
      throw new RuntimeException("Lojista não pode realizar transferência");
    }

    if (sender.getAccount().getBalance() < transactionDto.value()) {
      throw new RuntimeException("Saldo insuficiente");
    }
  }

  public void getUser(long id) {
    User user = userRepository.getReferenceById(id);
    System.out.println(user.toString());
  }

}
