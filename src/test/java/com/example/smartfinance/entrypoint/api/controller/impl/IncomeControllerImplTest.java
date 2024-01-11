package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.dto.PeriodicityInputDTO;
import com.example.smartfinance.entrypoint.api.facade.IncomeFacade;
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

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IncomeControllerImplTest {

    private static final String CONSUMER_ID = "1";
    private static final String INCOME_ID = "659dbd0bf4ab1e2f5340cfe5";
    private static final String DATE = "2024-01-18";

    @Mock
    IncomeFacade incomeFacade;

    @InjectMocks
    IncomeControllerImpl incomeController;

    private EasyRandom easyRandom;

    @BeforeEach
    void setUp() {
        var parameters = new EasyRandomParameters().objectFactory(new RecordFactory());
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    @DisplayName("Should successful create income")
    void should_create_income() {
        var incomeInputDTO = easyRandom.nextObject(IncomeInputDTO.class);
        var incomeOutputDTO =  easyRandom.nextObject(IncomeOutputDTO.class);

        when(incomeFacade.create(CONSUMER_ID, incomeInputDTO)).thenReturn(incomeOutputDTO);

        IncomeOutputDTO response = incomeController.create(CONSUMER_ID, incomeInputDTO);

        verify(incomeFacade, only()).create(anyString(), eq(incomeInputDTO));
        assertEquals(incomeOutputDTO, response);
    }

    @Test
    @DisplayName("Should successful get income by id")
    void should_get_income() {
        var incomeOutputDTO =  easyRandom.nextObject(IncomeOutputDTO.class);

        when(incomeFacade.get(CONSUMER_ID, INCOME_ID)).thenReturn(incomeOutputDTO);

        IncomeOutputDTO response = incomeController.get(CONSUMER_ID, INCOME_ID);

        verify(incomeFacade, only()).get(anyString(), anyString());
        assertEquals(incomeOutputDTO, response);
    }

    @Test
    @DisplayName("Should successful get income by period")
    void should_get_income_by_period() {
        var inputDTO = easyRandom.nextObject(PeriodicityInputDTO.class);

        List<IncomeOutputDTO> incomeOutputDTO = Collections.singletonList(easyRandom.nextObject(IncomeOutputDTO.class));

        when(incomeFacade.getByPeriod(CONSUMER_ID, DATE, inputDTO)).thenReturn(incomeOutputDTO);

        List<IncomeOutputDTO> response = incomeController.getByPeriod(CONSUMER_ID, DATE, inputDTO);

        verify(incomeFacade, only()).getByPeriod(CONSUMER_ID, DATE, inputDTO);
        assertEquals(incomeOutputDTO, response);
    }

}
