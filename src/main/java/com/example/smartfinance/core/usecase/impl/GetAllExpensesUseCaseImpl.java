package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.core.gateway.ExpenseGateway;
import com.example.smartfinance.core.usecase.GetAllExpensesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllExpensesUseCaseImpl implements GetAllExpensesUseCase {

    private final ExpenseGateway expenseGateway;

    @Override
    public List<ExpenseDomain> getAll() {
        return expenseGateway.getAll();
    }
}
