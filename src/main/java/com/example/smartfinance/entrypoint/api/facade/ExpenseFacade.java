package com.example.smartfinance.entrypoint.api.facade;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.core.usecase.CreateExpenseUseCase;
import com.example.smartfinance.entrypoint.api.dto.ExpenseInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ExpenseOutputDTO;
import com.example.smartfinance.entrypoint.api.mapper.ExpenseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ExpenseFacade {

    private final ExpenseMapper expenseMapper;

    private final CreateExpenseUseCase createExpenseUseCase;

    public ExpenseOutputDTO create(String consumerId, ExpenseInputDTO expenseInputDTO) {
        ExpenseDomain expenseDomain = expenseMapper.toDomain(consumerId, expenseInputDTO);

        return expenseMapper.toDTO(createExpenseUseCase.create(expenseDomain));
    }


}
