package com.example.smartfinance.entrypoint.api.controller.impl;

import com.example.smartfinance.entrypoint.api.controller.ConsumerController;
import com.example.smartfinance.entrypoint.api.dto.ConsumerInputDTO;
import com.example.smartfinance.entrypoint.api.dto.ConsumerOutputDTO;
import com.example.smartfinance.entrypoint.api.facade.ConsumerFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsumerControllerImpl implements ConsumerController {

    private final ConsumerFacade consumerFacade;

    @Override
    public ConsumerOutputDTO create(ConsumerInputDTO consumerInputDTO) {
        return consumerFacade.create(consumerInputDTO);
    }
}
