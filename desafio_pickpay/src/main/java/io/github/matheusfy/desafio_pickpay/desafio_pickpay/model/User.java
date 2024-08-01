package io.github.matheusfy.desafio_pickpay.desafio_pickpay.model;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.account.Account;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @Column(unique = true)
  private String email;

  private String password;

  @Column(unique = true)
  private String document;

  private int profile;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "account_id")
  private Account account;

  @Override
  public String toString() {
    return "User: id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", document="
        + document + ", profile=" + profile + ", account balance" + account.getBalance();
  }

}
