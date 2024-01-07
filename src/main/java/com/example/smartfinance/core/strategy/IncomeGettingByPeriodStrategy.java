package com.example.smartfinance.core.strategy;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.enumaration.Periodicity;

import java.util.List;

public interface IncomeGettingByPeriodStrategy {

    Periodicity getPeriodicity();

    List<IncomeDomain> getIncomeByPeriod(final IncomeDomain incomeDomain);
}
