package com.example.smartfinance.dataprovider.gateway;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.exception.ConsumerIncomeNotFound;
import com.example.smartfinance.core.gateway.IncomeGateway;
import com.example.smartfinance.dataprovider.database.entity.IncomeEntity;
import com.example.smartfinance.dataprovider.database.mapper.EntityMapper;
import com.example.smartfinance.dataprovider.database.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IncomeGatewayImpl implements IncomeGateway {

    private final IncomeRepository incomeRepository;
    private final EntityMapper entityMapper;

    @Override
    public IncomeDomain save(IncomeDomain incomeDomain) {
        IncomeEntity incomeEntity = entityMapper.toEntity(incomeDomain);
        return entityMapper.toDomain(incomeRepository.save(incomeEntity));
    }

    @Override
    public IncomeDomain get(IncomeDomain incomeDomain) {
        return incomeRepository.findByIdAndConsumerId(incomeDomain.id(), incomeDomain.consumerId())
                .map(entityMapper::toDomain)
                .orElseThrow(() -> new ConsumerIncomeNotFound(incomeDomain.id(), incomeDomain.consumerId()));
    }
}