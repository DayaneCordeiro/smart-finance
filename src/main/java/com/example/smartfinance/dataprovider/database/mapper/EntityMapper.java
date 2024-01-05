package com.example.smartfinance.dataprovider.database.mapper;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.dataprovider.database.entity.IncomeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityMapper {

    IncomeEntity toEntity(IncomeDomain incomeDomain);

    IncomeDomain toDomain(IncomeEntity incomeEntity);
}
