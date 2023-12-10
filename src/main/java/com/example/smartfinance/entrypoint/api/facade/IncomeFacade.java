package com.example.smartfinance.entrypoint.api.facade;

import com.example.smartfinance.core.usecase.GetIncomeUseCase;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.mapper.IncomeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class IncomeFacade {

    private final GetIncomeUseCase incomeUseCase;
    private final IncomeMapper incomeMapper;

    public List<IncomeOutputDTO> getIncomes(String consumerId, IncomeInputDTO incomeInputDTO) {
        final var incomeDomain = incomeMapper.from(incomeInputDTO);

        return incomeMapper.toDTO(incomeUseCase.getIncome(consumerId, incomeDomain));
    }
}
