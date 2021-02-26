package com.meubolso.repository;

import com.meubolso.currency_api.provider.GetCurrencyApi;

public class CurrencyRepository {

    GetCurrencyApi api;

    public Object getCurrency(){

        var teste = api.getCurrency();

        return teste;
    }

}
