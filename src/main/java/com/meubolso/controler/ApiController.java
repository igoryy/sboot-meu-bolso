package com.meubolso.controler;

import com.meubolso.provider.api.V1Api;
import com.meubolso.provider.presentation.representation.ListCurrencyRepresentation;
import com.meubolso.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements V1Api {

    @Autowired
    CurrencyService service;

    @Override
    public ResponseEntity<ListCurrencyRepresentation> getCurrency() {

        var teste = service.getCurrency();

        return null;

    }
}
