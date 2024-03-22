package com.example.smartfinance.core.usecase;

import com.example.smartfinance.core.domain.ExpenseDomain;

import java.util.List;

public interface GetAllExpensesUseCase {

    List<ExpenseDomain> getAll();
}
