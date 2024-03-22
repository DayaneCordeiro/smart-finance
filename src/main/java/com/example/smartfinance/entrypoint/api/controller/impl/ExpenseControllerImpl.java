package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.entrypoint.api.controller.ExpenseController;
import com.example.smartfinance.entrypoint.api.dto.expense.ExpenseRequestDTO;
import com.example.smartfinance.entrypoint.api.dto.expense.ExpenseResponseDTO;
import com.example.smartfinance.entrypoint.api.facade.ExpenseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExpenseControllerImpl implements ExpenseController {

    private final ExpenseFacade expenseFacade;

    @Override
    public ExpenseResponseDTO create(String consumerId, ExpenseRequestDTO expenseRequestDTO) {
        return expenseFacade.create(consumerId, expenseRequestDTO);
    }

    @Override
    public ExpenseResponseDTO get(String consumerId, String id) {
        return expenseFacade.get(consumerId, id);
    }
}
