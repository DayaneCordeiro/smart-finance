package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.core.gateway.ExpenseGateway;
import com.example.smartfinance.core.usecase.CreateExpenseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateExpenseUseCaseImpl implements CreateExpenseUseCase {

    private final ExpenseGateway expenseGateway;

    @Override
    public ExpenseDomain create(ExpenseDomain expenseDomain) {
        return expenseGateway.create(expenseDomain);
    }
}
