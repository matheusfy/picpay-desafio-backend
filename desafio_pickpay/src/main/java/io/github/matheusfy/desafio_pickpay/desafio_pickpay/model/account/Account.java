package io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.account;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
