package io.github.matheusfy.desafio_pickpay.desafio_pickpay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private Double balance;

  @OneToOne(mappedBy = "account")
  private User user;

  public void debit(Double value) {
    this.balance = balance - value;
  }

  public void credit(Double value) {
    this.balance = balance + value;
  }

}
