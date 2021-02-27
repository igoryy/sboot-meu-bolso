package com.meubolso.repository;

import com.meubolso.currency_api.DataIntegration;
import com.meubolso.provider.presentation.representation.BTCRepresentation;
import com.meubolso.provider.presentation.representation.DataRepresentation;
import com.meubolso.provider.presentation.representation.EURRepresentation;
import com.meubolso.provider.presentation.representation.USDRepresentation;

public class CurrencyMapper {


    public static DataRepresentation toRepresentation(DataIntegration dataIntegration){


        var btcIntegration = dataIntegration.getBTC();
        var btcRepresentation = new BTCRepresentation().code(btcIntegration.getCode())
                .codein(btcIntegration.getCodein())
                .name(btcIntegration.getName())
                .high(btcIntegration.getHigh())
                .low(btcIntegration.getLow())
                .timestamp(btcIntegration.getTimestamp())
                .varBid(btcIntegration.getVarBid());

        var eurIntegration = dataIntegration.getEUR();
        var eurRepresentation = new EURRepresentation().code(eurIntegration.getCode())
                .codein(eurIntegration.getCodein())
                .name(eurIntegration.getName())
                .high(eurIntegration.getHigh())
                .low(eurIntegration.getLow())
                .timestamp(eurIntegration.getTimestamp())
                .varBid(eurIntegration.getVarBid());

        var usdIntegration = dataIntegration.getUSD();
        var usdRepresentation = new USDRepresentation().code(usdIntegration.getCode())
                .codein(usdIntegration.getCodein())
                .name(usdIntegration.getName())
                .high(usdIntegration.getHigh())
                .low(usdIntegration.getLow())
                .timestamp(usdIntegration.getTimestamp())
                .varBid(usdIntegration.getVarBid());
        var response = new DataRepresentation();

        response.BTC(btcRepresentation).USD(usdRepresentation).EUR(eurRepresentation);


        return response;
    }

}
