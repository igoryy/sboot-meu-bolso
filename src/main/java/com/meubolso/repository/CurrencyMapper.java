package com.meubolso.repository;

import com.meubolso.currency_api.DataIntegration;
import com.meubolso.domain.CurrencyDomain;
import com.meubolso.domain.ListCurrency;
import com.meubolso.provider.presentation.representation.BTCRepresentation;
import com.meubolso.provider.presentation.representation.DataRepresentation;
import com.meubolso.provider.presentation.representation.EURRepresentation;
import com.meubolso.provider.presentation.representation.USDRepresentation;

public class CurrencyMapper {


    public static ListCurrency toDomain(DataIntegration dataIntegration){

        var response = new ListCurrency();

        response.add(CurrencyDomain.builder()
                .code(dataIntegration.getBTC().getCode())
                .codein(dataIntegration.getBTC().getCodein())
                .name(dataIntegration.getBTC().getName())
                .high(dataIntegration.getBTC().getHigh())
                .low(dataIntegration.getBTC().getLow())
                .build());

        response.add(CurrencyDomain.builder()
                .code(dataIntegration.getEUR().getCode())
                .codein(dataIntegration.getEUR().getCodein())
                .name(dataIntegration.getEUR().getName())
                .high(dataIntegration.getEUR().getHigh())
                .low(dataIntegration.getEUR().getLow())
                .build());

        response.add(CurrencyDomain.builder()
                .code(dataIntegration.getUSD().getCode())
                .codein(dataIntegration.getUSD().getCodein())
                .name(dataIntegration.getUSD().getName())
                .high(dataIntegration.getUSD().getHigh())
                .low(dataIntegration.getUSD().getLow())
                .build());


        return response;

    }

    public static DataRepresentation toRepresentation(DataIntegration dataIntegration){


        var btcIntegration = dataIntegration.getBTC();
        var btcRepresentation = new BTCRepresentation().code(btcIntegration.getCode())
                .codein(btcIntegration.getCodein())
                .name(btcIntegration.getName())
                .high(btcIntegration.getHigh())
                .low(btcIntegration.getLow());

        var eurIntegration = dataIntegration.getEUR();
        var eurRepresentation = new EURRepresentation().code(eurIntegration.getCode())
                .codein(eurIntegration.getCodein())
                .name(eurIntegration.getName())
                .high(eurIntegration.getHigh())
                .low(eurIntegration.getLow());

        var usdIntegration = dataIntegration.getUSD();
        var usdRepresentation = new USDRepresentation().code(usdIntegration.getCode())
                .codein(usdIntegration.getCodein())
                .name(usdIntegration.getName())
                .high(usdIntegration.getHigh())
                .low(usdIntegration.getLow());

        var response = new DataRepresentation();

        response.BTC(btcRepresentation).USD(usdRepresentation).EUR(eurRepresentation);


        return response;
    }

}
