package com.example.smartfinance.core.domain;

import com.example.smartfinance.core.enumaration.ExpenseType;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record ExpenseDomain(
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
