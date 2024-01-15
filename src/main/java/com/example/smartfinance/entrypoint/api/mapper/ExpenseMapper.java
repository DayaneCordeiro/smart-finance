package com.example.smartfinance.entrypoint.api.mapper;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.entrypoint.api.dto.ExpenseInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ExpenseOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExpenseMapper {

    @Mapping(target = "consumerId", source = "consumerId")
    ExpenseDomain toDomain(String consumerId, ExpenseInputDTO expenseInputDTO);

    ExpenseOutputDTO toDTO(ExpenseDomain expenseDomain);
}
