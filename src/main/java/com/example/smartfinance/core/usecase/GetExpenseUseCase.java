package com.example.smartfinance.core.usecase;

import com.example.smartfinance.core.domain.ExpenseDomain;

public interface GetExpenseUseCase {

    public ExpenseDomain get(ExpenseDomain expenseDomain);
}
