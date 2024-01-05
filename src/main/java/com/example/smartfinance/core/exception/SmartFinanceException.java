package com.example.smartfinance.core.exception;

import com.example.smartfinance.core.enumaration.ExceptionCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class SmartFinanceException extends RuntimeException {

    protected final HttpStatus status;
    protected final String code;
    protected final String message;

    SmartFinanceException(final ExceptionCode exceptionCode) {
        super();
        this.status = HttpStatus.UNPROCESSABLE_ENTITY;
        this.code = exceptionCode.code;
        this.message = exceptionCode.message;
    }

    SmartFinanceException(final ExceptionCode exceptionCode, final Object ...args) {
        super();
        this.status = HttpStatus.UNPROCESSABLE_ENTITY;
        this.code = exceptionCode.code;
        this.message = exceptionCode.message.formatted(args);
    }
}
