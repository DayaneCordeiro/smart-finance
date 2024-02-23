package com.example.smartfinance.entrypoint.api.dto;

import com.example.smartfinance.core.type.ExpenseType;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record ExpenseInputDTO(
    String id,
    String consumerId,
    String name,
    String description,
    ExpenseType type,
    LocalDate firstDueDate,
    BigDecimal totalValue,
    Integer installmentAmount,
    BigDecimal installmentValue
) {
}
