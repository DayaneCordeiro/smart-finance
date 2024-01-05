package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.gateway.IncomeGateway;
import com.example.smartfinance.core.usecase.IncomeCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IncomeCreateUseCaseImpl implements IncomeCreateUseCase {

    private final IncomeGateway incomeGateway;

    @Override
    public IncomeDomain create(IncomeDomain incomeDomain) {
        return incomeGateway.save(incomeDomain);
    }
}
