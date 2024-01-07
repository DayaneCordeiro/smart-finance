package com.example.smartfinance.entrypoint.api.dto;

import com.example.smartfinance.core.enumaration.Periodicity;
import io.swagger.v3.oas.annotations.media.Schema;

public record PeriodicityInputDTO (
        @Schema(description = "Periodicity", example = "MONTH")
        Periodicity periodicity
) {
}
