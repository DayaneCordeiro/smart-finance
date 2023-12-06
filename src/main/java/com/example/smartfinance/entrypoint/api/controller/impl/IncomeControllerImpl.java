package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.core.usecase.IncomeUseCase;
import com.example.smartfinance.entrypoint.api.controller.IncomeController;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.mapper.IncomeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IncomeControllerImpl implements IncomeController {

//    private final IncomeUseCase incomeUseCase;
//    private final IncomeMapper incomeMapper;

    @Override
    public List<IncomeOutputDTO> getIncomes(String consumerId, IncomeInputDTO incomeInputDTO) {
        return null;
    }
}
