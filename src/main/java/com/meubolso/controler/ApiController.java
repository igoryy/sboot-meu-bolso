package com.meubolso.controler;

import com.meubolso.provider.api.V1Api;
import com.meubolso.provider.presentation.representation.DataRepresentation;
import com.meubolso.repository.CurrencyMapper;
import com.meubolso.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class ApiController implements V1Api {

    private final CurrencyService service;

    @Override
    public ResponseEntity<DataRepresentation> getCurrency() {

        log.info("getCurrency :: > Tentativa de busca ");
        var response = service.getCurrency();
        return ResponseEntity.ok(CurrencyMapper.toRepresentation(response));

    }
}
