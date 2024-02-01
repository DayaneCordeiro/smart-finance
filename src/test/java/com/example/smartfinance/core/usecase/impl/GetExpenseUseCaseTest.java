package com.example.smartfinance.core.usecase.impl;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.core.gateway.ExpenseGateway;
import com.example.smartfinance.core.usecase.impl.GetExpenseUseCaseImpl;
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
public class GetExpenseUseCaseTest {

    @InjectMocks
    GetExpenseUseCaseImpl getExpenseUseCase;

    @Mock
    ExpenseGateway expenseGateway;

    private EasyRandom easyRandom;

    @BeforeEach
    void setUp() {
        var parameters = new EasyRandomParameters().objectFactory(new RecordFactory());
        easyRandom = new EasyRandom(parameters);
    }

    @Test
    @DisplayName("Should get expense")
    void should_get_expense() {
        ExpenseDomain expenseDomain = easyRandom.nextObject(ExpenseDomain.class);

        when(expenseGateway.get(expenseDomain)).thenReturn(expenseDomain);

        ExpenseDomain response = getExpenseUseCase.get(expenseDomain);

        assertEquals(response, expenseDomain);
        verify(expenseGateway, only()).get(expenseDomain);
    }
}
