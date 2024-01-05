package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.gateway.IncomeGateway;
import com.example.smartfinance.core.usecase.GetIncomeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetIncomeUseCaseImpl implements GetIncomeUseCase {

    private final IncomeGateway incomeGateway;

    @Override
    public IncomeDomain get(IncomeDomain incomeDomain) {

        return incomeGateway.get(incomeDomain);
    }
}
