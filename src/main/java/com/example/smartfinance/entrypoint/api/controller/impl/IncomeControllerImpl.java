package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.entrypoint.api.controller.IncomeController;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.dto.PeriodicityInputDTO;
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
    public IncomeOutputDTO get(String consumerId, String id) {
        return incomeFacade.get(consumerId, id);
    }

    @Override
    public List<IncomeOutputDTO> getByPeriod(String consumerId, String date, PeriodicityInputDTO inputDTO) {
        return incomeFacade.getByPeriod(consumerId, date, inputDTO);
    }

    @Override
    public void deleteIncome(String consumerId, String id) {
        incomeFacade.deleteIncome(consumerId, id);
    }

    @Override
    public void updateIncome(String consumerId, String id, IncomeInputDTO incomeInputDTO) {
        incomeFacade.updateIncome(consumerId, id, incomeInputDTO);
    }
}
