package com.example.smartfinance.entrypoint.api.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Builder
public record IncomeInputDTO(
    String id,
    String consumerId,
    String name,
    String description,
    BigDecimal value,
    Month month,
    Integer year,
    LocalDate date
) {
}
