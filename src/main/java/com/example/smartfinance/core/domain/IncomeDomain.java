package com.example.smartfinance.core.domain;

import com.example.smartfinance.core.enumaration.IncomeStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Builder
public record IncomeDomain (
    String id,
    String consumerId,
    String name,
    String description,
    BigDecimal value,
    LocalDate date,
    Month month,
    Integer year,
    IncomeStatus status
) {
}
