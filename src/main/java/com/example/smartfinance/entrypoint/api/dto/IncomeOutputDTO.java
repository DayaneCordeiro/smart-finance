package com.example.smartfinance.entrypoint.api.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Builder
public record IncomeOutputDTO(
    String id,
    String consumerId,
    String name,
    String description,
    BigDecimal value,
    LocalDate date,
    Month month,
    Integer day
) {
}
