package com.example.smartfinance.entrypoint.api.facade;

import com.example.smartfinance.core.domain.ExpenseDomain;
import com.example.smartfinance.core.usecase.CreateExpenseUseCase;
import com.example.smartfinance.core.usecase.GetExpenseUseCase;
import com.example.smartfinance.entrypoint.api.dto.expense.ExpenseRequestDTO;
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

    private final GetExpenseUseCase getExpenseUseCase;

    public ExpenseOutputDTO create(String consumerId, ExpenseRequestDTO expenseRequestDTO) {
        ExpenseDomain expenseDomain = expenseMapper.toDomain(consumerId, expenseRequestDTO);

        return expenseMapper.toDTO(createExpenseUseCase.create(expenseDomain));
    }

    public ExpenseOutputDTO get(String consumerId, String id) {
        ExpenseDomain expenseDomain = expenseMapper.toDomain(consumerId, id);

        return expenseMapper.toDTO(getExpenseUseCase.get(expenseDomain));
    }

}
