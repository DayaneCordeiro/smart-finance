package com.example.smartfinance.core.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record IncomeDomain (
    String id,
    String consumerId,
    String name,
    String description,
    BigDecimal value,
    LocalDate date
) {
}
