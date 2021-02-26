package com.meubolso.repository;

import com.meubolso.currency_api.provider.GetCurrencyApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CurrencyRepository {

    GetCurrencyApi api;

    public Object getCurrency(){

        var teste = api.getCurrency();

        return teste;
    }

}
