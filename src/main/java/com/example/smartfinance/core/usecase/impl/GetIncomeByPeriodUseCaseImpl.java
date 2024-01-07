package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.enumaration.Periodicity;
import com.example.smartfinance.core.exception.InvalidPeriodException;
import com.example.smartfinance.core.strategy.IncomeGettingByPeriodStrategy;
import com.example.smartfinance.core.usecase.GetIncomeByPeriodUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class GetIncomeByPeriodUseCaseImpl implements GetIncomeByPeriodUseCase {

    private final Map<Periodicity, IncomeGettingByPeriodStrategy> strategies;

    public GetIncomeByPeriodUseCaseImpl(List<IncomeGettingByPeriodStrategy> strategies) {
        this.strategies = strategies.stream()
                .collect(Collectors.toMap(IncomeGettingByPeriodStrategy::getPeriodicity, Function.identity()));
    }

    @Override
    public List<IncomeDomain> getByPeriod(IncomeDomain incomeDomain, Periodicity periodicity) {
        return Optional.ofNullable(strategies.get(periodicity))
                .map(strategy -> strategy.getIncomeByPeriod(incomeDomain))
                .orElseThrow(() -> new InvalidPeriodException(periodicity));
    }
}
