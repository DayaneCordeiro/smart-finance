package com.example.smartfinance.core.enumaration;

public enum ExceptionCode {

    CONSUMER_INCOME_NOT_FOUND("Income not found to id %s and ConsumerId %s", "SF0001");

    public final String code;
    public final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
