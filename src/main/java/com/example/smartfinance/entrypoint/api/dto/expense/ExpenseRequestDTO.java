package com.example.smartfinance.entrypoint.api.dto.expense;

import com.example.smartfinance.core.enumaration.ExpenseStatus;
import com.example.smartfinance.core.type.ExpenseType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record ExpenseRequestDTO(
    @Schema(description = "Id do cliente", example = "65b05a9de15f5e03b52c957f")
    String consumerId,
    @Schema(description = "Nome da despesa", example = "Fatura Picpay")
    String name,
    @Schema(description = "Descrição da despesa", example = "Compras feitas no mercado livre.")
    String description,
    @Schema(description = "Tipo da despesa", example = "FIXED")
    ExpenseType type,
    @Schema(description = "Status da despesa", example = "Fatura Picpay")
    ExpenseStatus status,
    @Schema(description = "Data do vencimento", example = "2024-02-10")
    LocalDate firstDueDate,
    @Schema(description = "Valor total", example = "1500.00")
    BigDecimal totalValue,
    @Schema(description = "Quantidade de parcelas", example = "5")
    Integer installmentsAmount,
    @Schema(description = "Valor da parcela", example = "300.00")
    BigDecimal installmentsValue
) {
}
