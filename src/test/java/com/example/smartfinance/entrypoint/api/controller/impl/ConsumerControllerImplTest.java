package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.entrypoint.api.dto.ConsumerInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ConsumerOutputDTO;
import com.example.smartfinance.entrypoint.api.facade.ConsumerFacade;
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
public class ConsumerControllerImplTest {

    @Mock
    ConsumerFacade consumerFacade;

    @InjectMocks
    ConsumerControllerImpl consumerController;

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

        when(consumerFacade.create(inputDTO)).thenReturn(outputDTO);

        ConsumerOutputDTO response = consumerController.create(inputDTO);

        assertEquals(response, outputDTO);
        verify(consumerFacade, only()).create(inputDTO);
    }
}
