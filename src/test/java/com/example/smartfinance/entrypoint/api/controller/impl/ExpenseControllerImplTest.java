package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.entrypoint.api.dto.expense.ExpenseRequestDTO;
import com.example.smartfinance.entrypoint.api.dto.ExpenseOutputDTO;
import com.example.smartfinance.entrypoint.api.facade.ExpenseFacade;
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
public class ExpenseControllerImplTest {

    private static final String CONSUMER_ID = "1";

    private static final String ID = "1";

    @Mock
    ExpenseFacade expenseFacade;

    @InjectMocks
    ExpenseControllerImpl expenseController;

    private EasyRandom easyRandom;

    @BeforeEach
    void setUp() {
        var parameters = new EasyRandomParameters().objectFactory(new RecordFactory());
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    @DisplayName("Should create expense")
    void should_create_expense() {
        ExpenseRequestDTO inputDTO = easyRandom.nextObject(ExpenseRequestDTO.class);
        ExpenseOutputDTO outputDTO = easyRandom.nextObject(ExpenseOutputDTO.class);

        when(expenseFacade.create(CONSUMER_ID, inputDTO)).thenReturn(outputDTO);

        ExpenseOutputDTO response = expenseController.create(CONSUMER_ID, inputDTO);

        assertEquals(response, outputDTO);
        verify(expenseFacade, only()).create(CONSUMER_ID, inputDTO);
    }

    @Test
    @DisplayName("Should get expense by id")
    void should_get_expense() {
        ExpenseOutputDTO outputDTO = easyRandom.nextObject(ExpenseOutputDTO.class);

        when(expenseFacade.get(CONSUMER_ID, ID)).thenReturn(outputDTO);

        ExpenseOutputDTO response = expenseController.get(CONSUMER_ID, ID);

        assertEquals(response, outputDTO);
        verify(expenseFacade, only()).get(CONSUMER_ID, ID);
    }
}
