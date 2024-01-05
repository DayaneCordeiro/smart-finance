package com.example.smartfinance.entrypoint.api.controller;

import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.dto.StandardErrorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.HEADER;

@Tag(name = "Incomes", description = "The income API")
@RequestMapping("/v1/incomes")
public interface IncomeController {

    @Operation(summary = "Create a income")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Income successful created",
            content = {@Content(
                mediaType = "application/json",
                schema = @Schema(implementation = IncomeOutputDTO.class)
            )}
    ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {@Content(
                mediaType = "application/json",
                schema = @Schema(implementation = StandardErrorDTO.class)
            )}
        )
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    IncomeOutputDTO create(
            @RequestHeader(value = "consumer-id") final String consumerId,
            @Valid @RequestBody final IncomeInputDTO incomeInputDTO
    );

    @Operation(summary = "Get incomes")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Income response",
            content = {@Content(
                mediaType = "application/json",
                schema = @Schema(implementation = IncomeOutputDTO.class)
            )}
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {@Content(
                mediaType = "application/json",
                schema = @Schema(implementation = StandardErrorDTO.class)
            )}
        )
    })
    @GetMapping
    List<IncomeOutputDTO> get(
        @RequestHeader(value = "consumer-id") final String consumerId,
        @Valid @RequestBody final IncomeInputDTO incomeInputDTO
    );
}
