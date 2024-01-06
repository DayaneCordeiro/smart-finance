package com.example.smartfinance.entrypoint.api.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record IncomeInputDTO(
    String id,
    String consumerId,
    String name,
    String description,
    BigDecimal value,
    LocalDate date
) {
}
