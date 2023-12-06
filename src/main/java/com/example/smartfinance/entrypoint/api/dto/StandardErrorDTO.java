package com.example.smartfinance.entrypoint.api.dto;

public record StandardErrorDTO(
        Long timestamp,
        Integer status,
        String code,
        String message,
        String path
) {
}
