package com.example.smartfinance.core.usecase;

import com.example.smartfinance.core.domain.IncomeDomain;

import java.util.List;

public interface GetIncomeUseCase {

    public List<IncomeDomain> getIncome(final String consumerId, final IncomeDomain incomeDomain);
}
