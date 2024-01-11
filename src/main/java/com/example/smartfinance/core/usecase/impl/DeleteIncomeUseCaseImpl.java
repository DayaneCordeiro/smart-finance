package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.gateway.IncomeGateway;
import com.example.smartfinance.core.usecase.DeleteIncomeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteIncomeUseCaseImpl implements DeleteIncomeUseCase {

    private final IncomeGateway incomeGateway;

    @Override
    public void deleteIncome(IncomeDomain incomeDomain) {
        incomeGateway.delete(incomeDomain);
    }
}
