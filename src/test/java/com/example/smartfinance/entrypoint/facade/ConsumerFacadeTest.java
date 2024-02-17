package com.example.smartfinance.entrypoint.facade;

import com.example.smartfinance.core.domain.ConsumerDomain;
import com.example.smartfinance.core.usecase.CreateConsumerUseCase;
import com.example.smartfinance.core.usecase.impl.CreateConsumerUseCaseImpl;
import com.example.smartfinance.entrypoint.api.dto.ConsumerInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ConsumerOutputDTO;
import com.example.smartfinance.entrypoint.api.facade.ConsumerFacade;
import com.example.smartfinance.entrypoint.api.mapper.ConsumerMapper;
import com.example.smartfinance.factory.RecordFactory;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsumerFacadeTest {

    @InjectMocks
    ConsumerFacade consumerFacade;

    @Mock
    ConsumerMapper consumerMapper;

    @Mock
    CreateConsumerUseCase createConsumerUseCase;

    private EasyRandom easyRandom;

    @BeforeEach
    void setUp() {
        var parameters = new EasyRandomParameters().objectFactory(new RecordFactory());
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    @DisplayName("Should create consumer")
    void should_create_consumer() {
        ConsumerInputDTO inputDTO = easyRandom.nextObject(ConsumerInputDTO.class);
        ConsumerOutputDTO outputDTO = easyRandom.nextObject(ConsumerOutputDTO.class);
        ConsumerDomain consumerDomain = easyRandom.nextObject(ConsumerDomain.class);

        when(consumerMapper.toDomain(inputDTO)).thenReturn(consumerDomain);
        when(consumerMapper.toDTO(consumerDomain)).thenReturn(outputDTO);
        when(createConsumerUseCase.create(consumerDomain)).thenReturn(consumerDomain);

        ConsumerOutputDTO response = consumerFacade.create(inputDTO);

        assertEquals(response, outputDTO);
        verify(createConsumerUseCase, only()).create(consumerDomain);
    }
}
