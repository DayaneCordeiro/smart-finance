package com.example.smartfinance.dataprovider.database.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "consumers")
public record ConsumerEntity(
    @Id
    String id,
    String name,
    String email,
    String password
) {
}
