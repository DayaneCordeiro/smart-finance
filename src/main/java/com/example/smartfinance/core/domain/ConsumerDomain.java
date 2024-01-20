package com.example.smartfinance.core.domain;

import lombok.Builder;

@Builder
public record ConsumerDomain(
    String id,
    String name,
    String email,
    String password
) {
}
