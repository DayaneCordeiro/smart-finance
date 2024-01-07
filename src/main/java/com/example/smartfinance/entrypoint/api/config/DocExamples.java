package com.example.smartfinance.entrypoint.api.config;

public final class DocExamples {

    public static final String INCOMES_BY_DATE_RESPONSE = """
            {
                "id": "6599dc992652f932bf3aaa86",
                "consumerId": 1,
                "name": "Salário",
                "description": null,
                "value": 4500.00,
                "date": "2024-01-05"
            }
            """;

    private DocExamples() {
        throw new IllegalStateException("Utility class");
    }
}
