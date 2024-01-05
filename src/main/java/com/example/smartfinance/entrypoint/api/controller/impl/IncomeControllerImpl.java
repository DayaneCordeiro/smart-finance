package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.entrypoint.api.controller.IncomeController;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.facade.IncomeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IncomeControllerImpl implements IncomeController {

    private final IncomeFacade incomeFacade;

    @Override
    public IncomeOutputDTO create(String consumerId, IncomeInputDTO incomeInputDTO) {
        return incomeFacade.create(consumerId, incomeInputDTO);
    }

    @Override
    public List<IncomeOutputDTO> get(String consumerId, IncomeInputDTO incomeInputDTO) {
        return null;
    }
}
