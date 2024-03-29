package com.example.smartfinance.core.enumaration;

public enum ExceptionCode {

    CONSUMER_INCOME_NOT_FOUND("Income not found to id %s and ConsumerId %s", "SF0001"),
    INVALID_PERIOD("Invalid Period %s", "SF0002"),
    CONSUMER_EXPENSE_NOT_FOUND("Expense not found to id %s and ConsumerId %s", "SF0003");

    public final String code;
    public final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
