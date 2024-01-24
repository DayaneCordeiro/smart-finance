package com.example.smartfinance.core.gateway;

import com.example.smartfinance.core.domain.ConsumerDomain;

public interface ConsumerGateway {

    ConsumerDomain create(ConsumerDomain consumerDomain);
}
