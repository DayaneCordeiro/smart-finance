package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.ConsumerDomain;
import com.example.smartfinance.core.gateway.ConsumerGateway;
import com.example.smartfinance.core.usecase.CreateConsumerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateConsumerUseCaseImpl implements CreateConsumerUseCase {

    private final ConsumerGateway consumerGateway;

    @Override
    public ConsumerDomain create(ConsumerDomain consumerDomain) {
        return consumerGateway.create(consumerDomain);
    }
}
