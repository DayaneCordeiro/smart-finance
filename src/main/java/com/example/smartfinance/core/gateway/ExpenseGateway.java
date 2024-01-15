package com.example.smartfinance.core.gateway;

import com.example.smartfinance.core.domain.ExpenseDomain;

public interface ExpenseGateway {

    ExpenseDomain create(ExpenseDomain expenseDomain);
}
