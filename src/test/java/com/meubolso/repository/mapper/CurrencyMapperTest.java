package com.meubolso.repository.mapper;

import com.meubolso.currency_api.BTCIntegration;
import com.meubolso.currency_api.DataIntegration;
import com.meubolso.currency_api.EURIntegration;
import com.meubolso.currency_api.USDIntegration;
import com.meubolso.repository.CurrencyMapper;
import org.junit.Test;

import static org.junit.Assert.*;
public class CurrencyMapperTest {


    @Test
    public void toDomain(){

        var response =
                CurrencyMapper.toRepresentation(buildMock());

        assertNotNull(response);
    }

    public DataIntegration buildMock(){

        BTCIntegration btc = new BTCIntegration();
        EURIntegration eur = new EURIntegration();
        USDIntegration usd = new USDIntegration();

        return new DataIntegration().BTC(btc).EUR(eur).USD(usd);

    }

}
