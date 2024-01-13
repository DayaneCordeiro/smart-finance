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
        IncomeDomain oldIncome = incomeGateway.get(incomeDomain);

        IncomeDomain newIncome = IncomeDomain.builder()
            .id(incomeDomain.id())
            .consumerId(incomeDomain.consumerId())
            .name(incomeDomain.name() == null ? oldIncome.name() : incomeDomain.name())
            .description(incomeDomain.description() == null ? oldIncome.description() : incomeDomain.description())
            .value(incomeDomain.value() == null ? oldIncome.value() : incomeDomain.value())
            .date(incomeDomain.date() == null ? oldIncome.date() : incomeDomain.date())
            .month(incomeDomain.month() == null ? oldIncome.month() : incomeDomain.month())
            .year(incomeDomain.year() == null ? oldIncome.year() : incomeDomain.year())
            .build();

        incomeGateway.update(newIncome);
    }
}
