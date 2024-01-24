package com.example.smartfinance.dataprovider.gateway;

import com.example.smartfinance.core.domain.ConsumerDomain;
import com.example.smartfinance.core.gateway.ConsumerGateway;
import com.example.smartfinance.dataprovider.database.entity.ConsumerEntity;
import com.example.smartfinance.dataprovider.database.mapper.EntityMapper;
import com.example.smartfinance.dataprovider.database.repository.ConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumerGatewayImpl implements ConsumerGateway {

    private final EntityMapper entityMapper;

    private final ConsumerRepository consumerRepository;

    @Override
    public ConsumerDomain create(ConsumerDomain consumerDomain) {
        ConsumerEntity consumerEntity = entityMapper.toEntity(consumerDomain);

        return entityMapper.toDomain(consumerRepository.save(consumerEntity));
    }
}
