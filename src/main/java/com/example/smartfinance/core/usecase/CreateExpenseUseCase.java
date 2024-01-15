package com.example.smartfinance.core.usecase;

import com.example.smartfinance.core.domain.ExpenseDomain;

public interface CreateExpenseUseCase {

    ExpenseDomain create(ExpenseDomain expenseDomain);
}
