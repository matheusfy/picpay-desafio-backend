package io.github.matheusfy.desafio_pickpay.desafio_pickpay.model;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos.TransactionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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

  @Override
    public String toString(){
//      return "Trasaction value: "+ value +", senderId: " + senderId + ", receiverId: " + receiverId;
      return "Transaction{" +
          "value=" + value +
          "senderId="+ senderId +
          "receiverId=" + receiverId + '}';
  }

}
