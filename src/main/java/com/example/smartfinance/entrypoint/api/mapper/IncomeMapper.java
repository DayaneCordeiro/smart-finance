package com.example.smartfinance.entrypoint.api.mapper;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeMapper {

    IncomeDomain from(final IncomeInputDTO incomeInputDTO);

    IncomeOutputDTO toDTO(final IncomeDomain incomeDomain);
}
