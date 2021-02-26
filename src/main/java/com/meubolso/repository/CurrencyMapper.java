package com.meubolso.repository;

import com.meubolso.currency_api.DataIntegration;
import com.meubolso.domain.CurrencyDomain;
import com.meubolso.domain.ListCurrency;

import java.util.ArrayList;
import java.util.Currency;
import java.util.stream.Collectors;

public class CurrencyMapper {


    public static ListCurrency toDomain(DataIntegration dataIntegration){

        var response = new ListCurrency();

        response.add(CurrencyDomain.builder()
                .code(dataIntegration.getBTC().getCode())
                .codein(dataIntegration.getBTC().getCodein())
                .name(dataIntegration.getBTC().getName())
                .high(dataIntegration.getBTC().getHigh())
                .low(dataIntegration.getBTC().getLow())
                .build();

        response.add(CurrencyDomain.builder()
                .code(dataIntegration.getEUR().getCode())
                .codein(dataIntegration.getEUR().getCodein())
                .name(dataIntegration.getEUR().getName())
                .high(dataIntegration.getEUR().getHigh())
                .low(dataIntegration.getEUR().getLow())
                .build();

        response.add(CurrencyDomain.builder()
                .code(dataIntegration.getUSD().getCode())
                .codein(dataIntegration.getUSD().getCodein())
                .name(dataIntegration.getUSD().getName())
                .high(dataIntegration.getUSD().getHigh())
                .low(dataIntegration.getUSD().getLow())
                .build();


        return response;

    }

}
