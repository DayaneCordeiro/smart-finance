package com.example.smartfinance.core.gateway;

import com.example.smartfinance.core.domain.ExpenseDomain;

import java.util.List;

public interface ExpenseGateway {

    ExpenseDomain create(ExpenseDomain expenseDomain);

    ExpenseDomain get(ExpenseDomain expenseDomain);

    List<ExpenseDomain> getAll();
}
