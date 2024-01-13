package com.example.smartfinance.entrypoint.api.dto;

public record BusinessErrorDTO(

        Long timestamp,
        Integer status,
        String code,
        String message,
        String path
) {
}
