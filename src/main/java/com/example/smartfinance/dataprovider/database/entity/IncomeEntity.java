package com.example.smartfinance.dataprovider.database.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Document(collection = "incomes")
public record IncomeEntity (
        @Id
        String id,
        String consumerId,
        String name,
        String description,
        BigDecimal value,
        LocalDate date,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
