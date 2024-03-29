package com.example.smartfinance.entrypoint.api.controller;

import com.example.smartfinance.entrypoint.api.config.ApiDefaultErrorsResponse;
import com.example.smartfinance.entrypoint.api.dto.expense.ExpenseRequestDTO;
import com.example.smartfinance.entrypoint.api.dto.expense.ExpenseResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.HEADER;

@Tag(name = "Expenses", description = "The expenses API")
@RequestMapping("/v1/expenses")
public interface ExpenseController {

    @Operation(summary = "Create a expense")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponse(responseCode = "201", description = "Expense successful created",
        content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = ExpenseResponseDTO.class)
        )}
    )
    @ApiDefaultErrorsResponse
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ExpenseResponseDTO create(
        @RequestHeader(value = "consumer-id") final String consumerId,
        @Valid @RequestBody final ExpenseRequestDTO expenseRequestDTO
    );

    @Operation(summary = "Get expense")
    @Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponse(responseCode = "200", description = "Income response",
        content = {@Content(mediaType = "application/json",
            schema = @Schema(implementation = ExpenseResponseDTO.class)
        )}
    )
    @ApiDefaultErrorsResponse
    @GetMapping("/{id}")
    ExpenseResponseDTO get(
        @RequestHeader(value = "consumer-id") final String consumerId,
        @PathVariable @NotBlank final String id
    );

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "Get All expenses")
    //@Parameter(name = "consumer-id", in = HEADER, required = true, description = "consumer-id", example = "1")
    @ApiResponse(responseCode = "200", description = "Income response",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ExpenseResponseDTO.class)
            )}
    )
    @ApiDefaultErrorsResponse
    @GetMapping
    List<ExpenseResponseDTO> getAll(
            //@RequestHeader(value = "consumer-id") final String consumerId,
    );
}
