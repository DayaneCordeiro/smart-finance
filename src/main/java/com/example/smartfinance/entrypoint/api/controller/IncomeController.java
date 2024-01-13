package com.example.smartfinance.entrypoint.api.controller;

import com.example.smartfinance.entrypoint.api.config.ApiDefaultErrorsResponse;
import com.example.smartfinance.entrypoint.api.config.DocExamples;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.dto.PeriodicityInputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.HEADER;

@Tag(name = "Incomes", description = "The income API")
@RequestMapping("/v1/incomes")
public interface IncomeController {

    @Operation(summary = "Create a income")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponse(responseCode = "201", description = "Income successful created",
        content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = IncomeOutputDTO.class)
        )}
    )
    @ApiDefaultErrorsResponse
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    IncomeOutputDTO create(
        @RequestHeader(value = "consumer-id") final String consumerId,
        @Valid @RequestBody final IncomeInputDTO incomeInputDTO
    );

    @Operation(summary = "Get income")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponse(responseCode = "200", description = "Income response",
        content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = IncomeOutputDTO.class)
        )}
    )
    @ApiDefaultErrorsResponse
    @GetMapping("/{id}")
    IncomeOutputDTO get(
        @RequestHeader(value = "consumer-id") final String consumerId,
        @PathVariable @NotBlank final String id
    );

    @Operation(summary = "Get incomes by date")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponse(responseCode = "200", description = "Income response",
        content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(example = DocExamples.INCOMES_BY_DATE_RESPONSE))
        )}
    )
    @ApiDefaultErrorsResponse
    @GetMapping("/get-by-period/{date}")
    List<IncomeOutputDTO> getByPeriod(
        @RequestHeader(value = "consumer-id") final String consumerId,
        @PathVariable @NotBlank final String date,
        @RequestBody final PeriodicityInputDTO inputDTO
    );

    @Operation(summary = "Delete income")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponse(responseCode = "204", description = "Income response")
    @ApiDefaultErrorsResponse
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteIncome(
        @RequestHeader(value = "consumer-id") final String consumerId,
        @PathVariable @NotBlank final String id
    );

    @Operation(summary = "Update income")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponse(responseCode = "204", description = "Income successful updated.")
    @ApiDefaultErrorsResponse
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateIncome(
        @RequestHeader(value = "consumer-id") final String consumerId,
        @PathVariable @NotBlank final String id,
        @Valid @RequestBody final IncomeInputDTO incomeInputDTO
    );
}
