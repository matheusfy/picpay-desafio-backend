package io.github.matheusfy.desafio_pickpay.desafio_pickpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
