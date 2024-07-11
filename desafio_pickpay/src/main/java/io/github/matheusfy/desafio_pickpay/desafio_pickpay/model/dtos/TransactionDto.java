package io.github.matheusfy.desafio_pickpay.desafio_pickpay.model.dtos;

import jakarta.validation.constraints.NotNull;

public record TransactionDto(
        @NotNull Double value,
        @NotNull(message = "sender não pode estar vazio") long senderId,
        @NotNull(message = "receiver não pode estar vazio") long receiverId) {
}
