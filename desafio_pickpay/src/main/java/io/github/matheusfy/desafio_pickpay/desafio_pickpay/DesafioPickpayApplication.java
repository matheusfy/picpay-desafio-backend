package io.github.matheusfy.desafio_pickpay.desafio_pickpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DesafioPickpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPickpayApplication.class, args);
	}

}
