package com.example.smartfinance.core.exception;

import com.example.smartfinance.core.enumaration.ExceptionCode;

public class ConsumerExpenseNotFoundException extends SmartFinanceException {

    public ConsumerExpenseNotFoundException(String id, String consumerId) {
        super(ExceptionCode.CONSUMER_INCOME_NOT_FOUND, id, consumerId);
    }
}
