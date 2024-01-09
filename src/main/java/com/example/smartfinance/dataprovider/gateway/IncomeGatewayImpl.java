package com.example.smartfinance.dataprovider.gateway;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.exception.ConsumerIncomeNotFoundException;
import com.example.smartfinance.core.gateway.IncomeGateway;
import com.example.smartfinance.dataprovider.database.entity.IncomeEntity;
import com.example.smartfinance.dataprovider.database.mapper.EntityMapper;
import com.example.smartfinance.dataprovider.database.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
                .orElseThrow(() -> new ConsumerIncomeNotFoundException(incomeDomain.id(), incomeDomain.consumerId()));
    }

    @Override
    public List<IncomeDomain> getByDate(IncomeDomain incomeDomain) {

        return incomeRepository.findByDateAndConsumerId(incomeDomain.date(), incomeDomain.consumerId())
                .stream().map(entityMapper::toDomain).toList();
    }

    @Override
    public List<IncomeDomain> getByMonth(IncomeDomain incomeDomain) {
        return incomeRepository.findByMonthAndYearAndConsumerId(incomeDomain.month(), incomeDomain.year(), incomeDomain.consumerId())
                .stream().map(entityMapper::toDomain).toList();
    }

    @Override
    public List<IncomeDomain> getByYear(IncomeDomain incomeDomain) {
        return incomeRepository.findByYearAndConsumerId(incomeDomain.year(), incomeDomain.consumerId())
                .stream().map(entityMapper::toDomain).toList();
    }
}
