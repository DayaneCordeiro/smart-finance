package com.example.smartfinance.entrypoint.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.HEADER;

@Tag(name = "incomes", description = "The income API")
public interface IncomeController {

    @Operation(summary = "Incomes")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponses(value = {
        @ApiResponses(
            responseCode = "200",
            description = "Income response,",
            content = {@Content(
                mediaType = "application/json",
                schema = @Schema(implementation = IncomesOutputDTO.class)
            )}
        )
    })

    @GetMapping("")
}
