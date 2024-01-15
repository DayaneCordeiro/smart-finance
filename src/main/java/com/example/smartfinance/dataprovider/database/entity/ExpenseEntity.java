package com.example.smartfinance.dataprovider.database.entity;

import com.example.smartfinance.core.enumaration.ExpenseType;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Document(collection = "expenses")
public record ExpenseEntity (
    @Id
    String id,
    String consumerId,
    String name,
    String description,
    ExpenseType type,
    LocalDate firstDueDate,
    BigDecimal totalValue,
    Integer installmentAmount,
    BigDecimal installmentValue,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
){
}
