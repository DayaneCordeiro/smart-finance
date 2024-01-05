package com.example.smartfinance.entrypoint.api.facade;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.usecase.GetIncomeUseCase;
import com.example.smartfinance.core.usecase.IncomeCreateUseCase;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.mapper.IncomeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class IncomeFacade {

//    private final GetIncomeUseCase getIncomeUseCase;
    private final IncomeCreateUseCase incomeCreateUseCase;
    private final IncomeMapper incomeMapper;

    public IncomeOutputDTO create(String consumerId, IncomeInputDTO inputDTO) {
        IncomeDomain incomeDomain = incomeMapper.toDomain(inputDTO, consumerId);

        return incomeMapper.toDTO(incomeCreateUseCase.create(incomeDomain));
    }

//    public List<IncomeOutputDTO> getIncomes(String consumerId, IncomeInputDTO incomeInputDTO) {
//        final var incomeDomain = incomeMapper.from(incomeInputDTO);
//
//        return incomeMapper.toDTO(incomeUseCase.getIncome(consumerId, incomeDomain));
//    }
}
