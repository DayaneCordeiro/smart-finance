package com.example.smartfinance.entrypoint.facade;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.core.usecase.CreateExpenseUseCase;
import com.example.smartfinance.core.usecase.GetExpenseUseCase;
import com.example.smartfinance.entrypoint.api.dto.ExpenseInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ExpenseOutputDTO;
import com.example.smartfinance.entrypoint.api.facade.ExpenseFacade;
import com.example.smartfinance.entrypoint.api.mapper.ExpenseMapper;
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
public class ExpenseFacadeTest {

    private static final String CONSUMER_ID = "1";

    private static final String ID = "1";

    @InjectMocks
    ExpenseFacade expenseFacade;

    @Mock
    ExpenseMapper expenseMapper;

    @Mock
    CreateExpenseUseCase createExpenseUseCase;

    @Mock
    GetExpenseUseCase getExpenseUseCase;

    private EasyRandom easyRandom;

    @BeforeEach
    void setUp() {
        var parameters = new EasyRandomParameters().objectFactory(new RecordFactory());
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    @DisplayName("Should create a expense")
    void should_create_expense() {
        ExpenseInputDTO inputDTO = easyRandom.nextObject(ExpenseInputDTO.class);
        ExpenseOutputDTO outputDTO = easyRandom.nextObject(ExpenseOutputDTO.class);
        ExpenseDomain expenseDomain = easyRandom.nextObject(ExpenseDomain.class);

        when(expenseMapper.toDomain(CONSUMER_ID, inputDTO)).thenReturn(expenseDomain);
        when(expenseMapper.toDTO(expenseDomain)).thenReturn(outputDTO);
        when(createExpenseUseCase.create(expenseDomain)).thenReturn(expenseDomain);

        ExpenseOutputDTO response = expenseFacade.create(CONSUMER_ID, inputDTO);

        assertEquals(response, outputDTO);
        verify(createExpenseUseCase, only()).create(expenseDomain);
    }

    @Test
    @DisplayName("Should get a expense")
    void should_get_expense() {
        ExpenseDomain expenseDomain = easyRandom.nextObject(ExpenseDomain.class);
        ExpenseOutputDTO outputDTO = easyRandom.nextObject(ExpenseOutputDTO.class);

        when(expenseMapper.toDomain(CONSUMER_ID, ID)).thenReturn(expenseDomain);
        when(expenseMapper.toDTO(expenseDomain)).thenReturn(outputDTO);
        when(getExpenseUseCase.get(expenseDomain)).thenReturn(expenseDomain);

        ExpenseOutputDTO response = expenseFacade.get(CONSUMER_ID, ID);

        assertEquals(response, outputDTO);
        verify(getExpenseUseCase, only()).get(expenseDomain);
    }
}
