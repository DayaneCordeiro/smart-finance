package com.example.smartfinance.entrypoint.api.mapper;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.entrypoint.api.dto.expense.ExpenseRequestDTO;
import com.example.smartfinance.entrypoint.api.dto.expense.ExpenseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExpenseMapper {

    @Mapping(target = "consumerId", source = "consumerId")
    ExpenseDomain toDomain(String consumerId, ExpenseRequestDTO expenseRequestDTO);

    @Mapping(target = "consumerId", source = "consumerId")
    ExpenseDomain toDomain(String consumerId, String id);

    ExpenseResponseDTO toDTO(ExpenseDomain expenseDomain);

    List<ExpenseResponseDTO> toDTO(final List<ExpenseDomain> expenseDomain);
}
