package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.entrypoint.api.controller.ExpenseController;
import com.example.smartfinance.entrypoint.api.dto.ExpenseInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ExpenseOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExpenseControllerImpl implements ExpenseController {

    @Override
    public ExpenseOutputDTO create(String consumerId, ExpenseInputDTO expenseInputDTO) {
        return null;
    }
}
