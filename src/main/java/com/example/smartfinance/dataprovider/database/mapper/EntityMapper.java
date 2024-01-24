package com.example.smartfinance.dataprovider.database.mapper;

import com.example.smartfinance.core.domain.ConsumerDomain;
import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.dataprovider.database.entity.ConsumerEntity;
import com.example.smartfinance.dataprovider.database.entity.ExpenseEntity;
import com.example.smartfinance.dataprovider.database.entity.IncomeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityMapper {

    IncomeEntity toEntity(IncomeDomain incomeDomain);

    IncomeDomain toDomain(IncomeEntity incomeEntity);

    ExpenseEntity toEntity(ExpenseDomain expenseDomain);

    ExpenseDomain toDomain(ExpenseEntity expenseEntity);

    ConsumerEntity toEntity(ConsumerDomain consumerDomain);

    ConsumerDomain toDomain(ConsumerEntity consumerEntity);
}
