package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.core.usecase.GetExpenseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetExpenseUseCaseImpl implements GetExpenseUseCase {
    @Override
    public ExpenseDomain get(ExpenseDomain expenseDomain) {
        return null;
    }
}
