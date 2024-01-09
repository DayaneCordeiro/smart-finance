package com.example.smartfinance.entrypoint.api.mapper;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IncomeMapper {

    @Mapping(target = "id", source = "incomeInputDTO.id")
    @Mapping(target = "value", source = "incomeInputDTO.value")
    @Mapping(target = "consumerId", source = "consumerId")
    IncomeDomain toDomain(final IncomeInputDTO incomeInputDTO, final String consumerId, final Month month, final Integer year);

    IncomeDomain toDomain(final String consumerId, final String id);

    @Mapping(target = "date", source = "date")
    IncomeDomain toDomain(final String consumerId, final LocalDate date);

    IncomeOutputDTO toDTO(final IncomeDomain incomeDomain);

    List<IncomeOutputDTO> toDTO(final List<IncomeDomain> incomeDomain);
}
