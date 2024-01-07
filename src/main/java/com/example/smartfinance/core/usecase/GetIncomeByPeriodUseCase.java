package com.example.smartfinance.core.usecase;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.enumaration.Periodicity;

import java.util.List;

public interface GetIncomeByPeriodUseCase {

    public List<IncomeDomain> getByPeriod(IncomeDomain incomeDomain, Periodicity periodicity);
}
