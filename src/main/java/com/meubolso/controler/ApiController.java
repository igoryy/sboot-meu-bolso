package com.meubolso.controler;

import com.meubolso.ListCurrencyRepresentation;
import com.meubolso.provider.V1Api;
import com.meubolso.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class ApiController implements V1Api {

    @Autowired
    CurrencyService service;

    @Override
    public ResponseEntity<ListCurrencyRepresentation> getCurrency() {

        var teste = service.getCurrency();

        return null;

    }
}
