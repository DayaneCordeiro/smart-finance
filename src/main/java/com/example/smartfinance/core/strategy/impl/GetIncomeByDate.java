package com.example.smartfinance.core.strategy.impl;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.enumaration.Periodicity;
import com.example.smartfinance.core.gateway.IncomeGateway;
import com.example.smartfinance.core.strategy.IncomeGettingByPeriodStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetIncomeByDate implements IncomeGettingByPeriodStrategy {

    private final IncomeGateway incomeGateway;

    @Override
    public Periodicity getPeriodicity() {
        return Periodicity.DATE;
    }

    @Override
    public List<IncomeDomain> getIncomeByPeriod(IncomeDomain incomeDomain) {
        return incomeGateway.getByDate(incomeDomain);
    }
}
