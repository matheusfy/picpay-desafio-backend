package io.github.matheusfy.desafio_pickpay.desafio_pickpay.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos.TransactionDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private Double value;
  private long senderId;
  private long receiverId;

  @CreatedDate
  private LocalDateTime createDate;

  public Transaction(TransactionDto transaction) {
    this.value = transaction.value();
    this.senderId = transaction.senderId();
    this.receiverId = transaction.receiverId();
  }

}
