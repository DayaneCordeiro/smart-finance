package com.example.smartfinance.core.usecase;

import com.example.smartfinance.core.domain.ConsumerDomain;

public interface CreateConsumerUseCase {

    ConsumerDomain create(ConsumerDomain consumerDomain);
}
