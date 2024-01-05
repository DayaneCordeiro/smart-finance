package com.example.smartfinance.entrypoint.api.mapper;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeMapper {

    @Mapping(target = "id", source = "incomeInputDTO.id")
    IncomeDomain toDomain(final IncomeInputDTO incomeInputDTO, final String consumerId);

    IncomeDomain toDomain(final String consumerId, final String id);

    IncomeOutputDTO toDTO(final IncomeDomain incomeDomain);

    List<IncomeOutputDTO> toDTO(final List<IncomeDomain> incomeDomain);
}
