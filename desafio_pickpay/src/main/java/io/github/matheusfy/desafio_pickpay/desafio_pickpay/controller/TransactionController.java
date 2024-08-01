package io.github.matheusfy.desafio_pickpay.desafio_pickpay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos.TransactionDto;
import io.github.matheusfy.desafio_pickpay.desafio_pickpay.service.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class TransactionController {

  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping("/transfer")
  public ResponseEntity<String> transfer(@RequestBody @Valid TransactionDto transactionDto) {
    transactionService.transfer(transactionDto);
    return ResponseEntity.ok().body("Transação realizada com sucesso!");
  }

  @GetMapping("/hello")
  public ResponseEntity<String> hello(){
    return ResponseEntity.ok("Hello");
  }

}
