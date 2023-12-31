package com.example.smartfinance.entrypoint.api.facade;

import com.example.smartfinance.core.domain.IncomeDomain;
import com.example.smartfinance.core.enumaration.Periodicity;
import com.example.smartfinance.core.usecase.GetIncomeByPeriodUseCase;
import com.example.smartfinance.core.usecase.GetIncomeUseCase;
import com.example.smartfinance.core.usecase.IncomeCreateUseCase;
import com.example.smartfinance.entrypoint.api.dto.IncomeInputDTO;
import com.example.smartfinance.entrypoint.api.dto.IncomeOutputDTO;
import com.example.smartfinance.entrypoint.api.dto.PeriodicityInputDTO;
import com.example.smartfinance.entrypoint.api.mapper.IncomeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class IncomeFacade {

    private final GetIncomeUseCase getIncomeUseCase;
    private final IncomeCreateUseCase incomeCreateUseCase;
    private final GetIncomeByPeriodUseCase getIncomeByPeriodUseCase;
    private final IncomeMapper incomeMapper;

    public IncomeOutputDTO create(String consumerId, IncomeInputDTO inputDTO) {
        final Month month = inputDTO.date().getMonth();
        final int day = inputDTO.date().getDayOfMonth();

        IncomeDomain incomeDomain = incomeMapper.toDomain(inputDTO, consumerId, month, day);

        return incomeMapper.toDTO(incomeCreateUseCase.create(incomeDomain));
    }

    public IncomeOutputDTO get(String consumerId, String id) {
        IncomeDomain incomeDomain = incomeMapper.toDomain(consumerId, id);

        return incomeMapper.toDTO(getIncomeUseCase.get(incomeDomain));
    }

    public List<IncomeOutputDTO> getByPeriod(String consumerId, String date, PeriodicityInputDTO inputDTO) {
        LocalDate localDate = LocalDate.parse(date);

        IncomeDomain incomeDomain = incomeMapper.toDomain(consumerId, localDate);
        Periodicity periodicity = Periodicity.valueOf(inputDTO.periodicity().toString());

        return incomeMapper.toDTO(getIncomeByPeriodUseCase.getByPeriod(incomeDomain, periodicity));
    }
}
