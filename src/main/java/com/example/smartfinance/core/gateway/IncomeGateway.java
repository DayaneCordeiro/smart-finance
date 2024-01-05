package com.example.smartfinance.core.gateway;

import com.example.smartfinance.core.domain.IncomeDomain;

public interface IncomeGateway {

    IncomeDomain save(IncomeDomain incomeDomain);

    IncomeDomain get(IncomeDomain incomeDomain);
}
