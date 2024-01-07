package com.example.smartfinance.core.exception;

import com.example.smartfinance.core.enumaration.ExceptionCode;
import com.example.smartfinance.core.enumaration.Periodicity;

public class InvalidPeriodException extends SmartFinanceException {

    public InvalidPeriodException(Periodicity periodicity) {
        super(ExceptionCode.INVALID_PERIOD, periodicity.toString());
    }
}
