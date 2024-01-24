package com.example.smartfinance.entrypoint.api.mapper;

import com.example.smartfinance.core.domain.ConsumerDomain;
import com.example.smartfinance.entrypoint.api.dto.ConsumerInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ConsumerOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConsumerMapper {

    ConsumerDomain toDomain(ConsumerInputDTO inputDTO);

    ConsumerOutputDTO toDTO(ConsumerDomain consumerDomain);
}
