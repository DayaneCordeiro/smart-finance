package com.example.smartfinance.dataprovider.gateway;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.core.exception.ConsumerExpenseNotFoundException;
import com.example.smartfinance.core.gateway.ExpenseGateway;
import com.example.smartfinance.dataprovider.database.entity.ExpenseEntity;
import com.example.smartfinance.dataprovider.database.mapper.EntityMapper;
import com.example.smartfinance.dataprovider.database.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExpenseGatewayImpl implements ExpenseGateway {

    private final ExpenseRepository expenseRepository;

    private final EntityMapper entityMapper;

    @Override
    public ExpenseDomain create(ExpenseDomain expenseDomain) {
        ExpenseEntity expenseEntity = entityMapper.toEntity(expenseDomain);

        return entityMapper.toDomain(expenseRepository.save(expenseEntity));
    }

    @Override
    public ExpenseDomain get(ExpenseDomain expenseDomain) {
        return expenseRepository.getByIdAndConsumerId(expenseDomain.id(), expenseDomain.consumerId())
                .map(entityMapper::toDomain)
                .orElseThrow(() -> new ConsumerExpenseNotFoundException(expenseDomain.id(), expenseDomain.consumerId()));
    }

    @Override
    public List<ExpenseDomain> getAll() {
        return expenseRepository.findAll().stream().map(entityMapper::toDomain).toList();
    }
}
