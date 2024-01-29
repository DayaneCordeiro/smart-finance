package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.entrypoint.api.controller.ExpenseController;
import com.example.smartfinance.entrypoint.api.dto.ExpenseInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ExpenseOutputDTO;
import com.example.smartfinance.entrypoint.api.facade.ExpenseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExpenseControllerImpl implements ExpenseController {

    private final ExpenseFacade expenseFacade;

    @Override
    public ExpenseOutputDTO create(String consumerId, ExpenseInputDTO expenseInputDTO) {
        return expenseFacade.create(consumerId, expenseInputDTO);
    }

    @Override
    public ExpenseOutputDTO get(String consumerId, String id) {
        return expenseFacade.get(consumerId, id);
    }
}
