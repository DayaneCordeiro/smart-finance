package com.example.smartfinance.entrypoint.facade;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.enumaration.Periodicity;
import com.example.smartfinance.core.usecase.CreateIncomeUseCase;
import com.example.smartfinance.core.usecase.GetIncomeByPeriodUseCase;
import com.example.smartfinance.core.usecase.GetIncomeUseCase;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.dto.PeriodicityInputDTO;
import com.example.smartfinance.entrypoint.api.facade.IncomeFacade;
import com.example.smartfinance.entrypoint.api.mapper.IncomeMapper;
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
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IncomeFacadeTest {

    private static final String CONSUMER_ID = "1";
    private static final String ID = "1";

    @Mock
    IncomeMapper incomeMapper;

    @Mock
    CreateIncomeUseCase createIncomeUseCase;

    @Mock
    GetIncomeUseCase getIncomeUseCase;

    @Mock
    GetIncomeByPeriodUseCase getIncomeByPeriodUseCase;

    @InjectMocks
    IncomeFacade incomeFacade;


    private EasyRandom easyRandom;

    @BeforeEach
    void setUp() {
        var parameters = new EasyRandomParameters().objectFactory(new RecordFactory());
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    @DisplayName("Should create income")
    void should_create_income() {
        IncomeInputDTO inputDTO = easyRandom.nextObject(IncomeInputDTO.class);
        IncomeDomain incomeDomain = easyRandom.nextObject(IncomeDomain.class);
        IncomeOutputDTO outputDTO = easyRandom.nextObject(IncomeOutputDTO.class);

        final Month month = inputDTO.date().getMonth();
        final int year = inputDTO.date().getYear();

        when(incomeMapper.toDomain(inputDTO, CONSUMER_ID, month, year)).thenReturn(incomeDomain);
        when(incomeMapper.toDTO(incomeDomain)).thenReturn(outputDTO);
        when(createIncomeUseCase.create(incomeDomain)).thenReturn(incomeDomain);

        IncomeOutputDTO response = incomeFacade.create(CONSUMER_ID, inputDTO);

        assertEquals(response, outputDTO);
        verify(createIncomeUseCase, only()).create(incomeDomain);
    }

    @Test
    @DisplayName("Should get income")
    void should_get_income() {
        IncomeDomain incomeDomain = easyRandom.nextObject(IncomeDomain.class);
        IncomeOutputDTO outputDTO = easyRandom.nextObject(IncomeOutputDTO.class);

        when(incomeMapper.toDomain(CONSUMER_ID, ID)).thenReturn(incomeDomain);
        when(incomeMapper.toDTO(incomeDomain)).thenReturn(outputDTO);
        when(getIncomeUseCase.get(incomeDomain)).thenReturn(incomeDomain);

        IncomeOutputDTO response = incomeFacade.get(CONSUMER_ID, ID);

        assertEquals(response, outputDTO);
        verify(getIncomeUseCase, only()).get(incomeDomain);
    }

    @Test
    @DisplayName("Should get income by period")
    void should_get_income_by_period() {
        IncomeDomain incomeDomain = easyRandom.nextObject(IncomeDomain.class);
        List<IncomeOutputDTO> outputDTO = easyRandom.objects(IncomeOutputDTO.class, 2).toList();
        PeriodicityInputDTO periodicityInputDTO = easyRandom.nextObject(PeriodicityInputDTO.class);
        List<IncomeDomain> incomes = easyRandom.objects(IncomeDomain.class, 2).toList();

        LocalDate date = LocalDate.now();

        when(incomeMapper.toDomain(CONSUMER_ID, date)).thenReturn(incomeDomain);
        when(incomeMapper.toDTO(incomes)).thenReturn(outputDTO);
        when(getIncomeByPeriodUseCase.getByPeriod(incomeDomain, periodicityInputDTO.periodicity())).thenReturn(incomes);

        List<IncomeOutputDTO> response = incomeFacade.getByPeriod(CONSUMER_ID, date.toString(), periodicityInputDTO);

        assertEquals(response, outputDTO);
        verify(getIncomeByPeriodUseCase, only()).getByPeriod(incomeDomain, periodicityInputDTO.periodicity());
    }
}
