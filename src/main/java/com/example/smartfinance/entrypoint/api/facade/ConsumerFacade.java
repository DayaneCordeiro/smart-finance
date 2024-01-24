package com.example.smartfinance.entrypoint.api.facade;

import com.example.smartfinance.core.domain.ConsumerDomain;
import com.example.smartfinance.core.usecase.CreateConsumerUseCase;
import com.example.smartfinance.entrypoint.api.dto.ConsumerInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ConsumerOutputDTO;
import com.example.smartfinance.entrypoint.api.mapper.ConsumerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConsumerFacade {

    private final ConsumerMapper consumerMapper;

    private final CreateConsumerUseCase createConsumerUseCase;

    public ConsumerOutputDTO create(ConsumerInputDTO inputDTO) {
        ConsumerDomain consumerDomain = consumerMapper.toDomain(inputDTO);

        return consumerMapper.toDTO(createConsumerUseCase.create(consumerDomain));
    }
}
