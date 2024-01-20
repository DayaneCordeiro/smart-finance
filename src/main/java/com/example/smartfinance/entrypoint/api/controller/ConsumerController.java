package com.example.smartfinance.entrypoint.api.controller;

import com.example.smartfinance.entrypoint.api.config.ApiDefaultErrorsResponse;
import com.example.smartfinance.entrypoint.api.dto.ConsumerInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ConsumerOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Consumers", description = "The consumer API")
@RequestMapping("/v1/consumers")
public interface ConsumerController {

    @Operation(summary = "Create a consumer")
    @ApiResponse(responseCode = "201", description = "Consumer successful created",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ConsumerInputDTO.class)
            )}
    )
    @ApiDefaultErrorsResponse
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ConsumerOutputDTO create(
            @Valid @RequestBody final ConsumerInputDTO consumerInputDTO
    );
}
