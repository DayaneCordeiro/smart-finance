package com.example.smartfinance.dataprovider.gateway;

import com.example.smartfinance.dataprovider.database.repository.ExpenseRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExpenseGatewayImplTest {

    @InjectMocks
    ExpenseGatewayImpl expenseGateway;

    @Mock
    ExpenseRepository repository;
}
