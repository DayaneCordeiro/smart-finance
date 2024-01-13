package com.example.smartfinance.entrypoint.api.config;

import com.example.smartfinance.entrypoint.api.dto.BusinessErrorDTO;
import com.example.smartfinance.entrypoint.api.dto.StandardErrorDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
    @ApiResponse(responseCode = "400", description = "Invalid request",
        content = {@Content(mediaType = "application/json",
        schema = @Schema(implementation = StandardErrorDTO.class))}),
    @ApiResponse(responseCode = "422", description = "Business error",
        content = {@Content(mediaType = "application/json",
        schema = @Schema(implementation = BusinessErrorDTO.class))}),
    @ApiResponse(responseCode = "500", description = "Server internal error",
        content = {@Content(mediaType = "application/json",
        schema = @Schema(implementation = StandardErrorDTO.class))})
})
public @interface ApiDefaultErrorsResponse {
}
