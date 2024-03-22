package com.example.smartfinance.entrypoint.api.dto.expense;

import com.example.smartfinance.core.type.ExpenseType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record ExpenseResponseDTO(
    @Schema(description = "Identificador da despesa", example = "65b05a9de15f5e03b52c957f")
    String id,
    @Schema(description = "Identificador da despesa", example = "65b05a9de15f5e03b52c957f")
    String consumerId,
    @Schema(description = "Identificador da despesa", example = "65b05a9de15f5e03b52c957f")
    String name,
    @Schema(description = "Identificador da despesa", example = "65b05a9de15f5e03b52c957f")
    String description,
    @Schema(description = "Identificador da despesa", example = "65b05a9de15f5e03b52c957f")
    ExpenseType type,
    @Schema(description = "Identificador da despesa", example = "65b05a9de15f5e03b52c957f")
    LocalDate firstDueDate,
    @Schema(description = "Identificador da despesa", example = "65b05a9de15f5e03b52c957f")
    BigDecimal totalValue,
    @Schema(description = "Identificador da despesa", example = "65b05a9de15f5e03b52c957f")
    Integer installmentAmount,
    @Schema(description = "Identificador da despesa", example = "65b05a9de15f5e03b52c957f")
    BigDecimal installmentValue
) {
}
