package com.meubolso.repository;

import com.meubolso.currency_api.DataIntegration;
import com.meubolso.currency_api.provider.GetCurrencyApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CurrencyRepository {

    GetCurrencyApi api;

    public DataIntegration getCurrency(){
        var response = api.getCurrency();
        return response;
    }

}
