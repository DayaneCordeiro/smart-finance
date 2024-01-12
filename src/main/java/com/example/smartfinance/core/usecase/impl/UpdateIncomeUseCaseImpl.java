package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.gateway.IncomeGateway;
import com.example.smartfinance.core.usecase.UpdateIncomeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateIncomeUseCaseImpl implements UpdateIncomeUseCase {

    private final IncomeGateway incomeGateway;

    @Override
    public void updateIncome(IncomeDomain incomeDomain) {
        // TODO: criar lógica
    }
}
