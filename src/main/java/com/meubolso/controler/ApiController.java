package com.meubolso.controler;

import com.meubolso.provider.api.V1Api;
import com.meubolso.provider.presentation.representation.DataRepresentation;
import com.meubolso.repository.CurrencyMapper;
import com.meubolso.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ApiController implements V1Api {

    @Autowired
    CurrencyService service;

    @Override
    public ResponseEntity<DataRepresentation> getCurrency() {

        log.info("getCurrency :: > Tentativa de busca ");
        var response = service.getCurrency();
        return ResponseEntity.ok(CurrencyMapper.toRepresentation(response));

    }
}
