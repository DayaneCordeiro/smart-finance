package com.example.smartfinance.entrypoint.api.dto;

import lombok.Builder;

@Builder
public record ConsumerInputDTO(
    String name,
    String email,
    String password
) {
}
