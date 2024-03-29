package com.example.smartfinance.core.gateway;

import com.example.smartfinance.core.domain.IncomeDomain;

import java.util.List;

public interface IncomeGateway {

    IncomeDomain save(IncomeDomain incomeDomain);

    IncomeDomain get(IncomeDomain incomeDomain);

    List<IncomeDomain> getByDate(IncomeDomain incomeDomain);

    List<IncomeDomain> getByMonth(IncomeDomain incomeDomain);

    List<IncomeDomain> getByYear(IncomeDomain incomeDomain);

    void delete(IncomeDomain incomeDomain);

    void update(IncomeDomain incomeDomain);
}
