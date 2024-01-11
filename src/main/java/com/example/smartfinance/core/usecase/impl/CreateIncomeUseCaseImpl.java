package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.gateway.IncomeGateway;
import com.example.smartfinance.core.usecase.CreateIncomeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateIncomeUseCaseImpl implements CreateIncomeUseCase {

    private final IncomeGateway incomeGateway;

    @Override
    public IncomeDomain create(IncomeDomain incomeDomain) {
        return incomeGateway.save(incomeDomain);
    }
}
