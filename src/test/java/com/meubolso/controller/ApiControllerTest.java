package com.meubolso.controller;

import com.meubolso.controler.ApiController;
import com.meubolso.currency_api.BTCIntegration;
import com.meubolso.currency_api.DataIntegration;
import com.meubolso.currency_api.EURIntegration;
import com.meubolso.currency_api.USDIntegration;
import com.meubolso.currency_api.provider.GetCurrencyApi;
import com.meubolso.service.CurrencyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiControllerTest {

    private static ApiController api;
    private static CurrencyService service;

    @Before
    public void setup(){
        service = mock(CurrencyService.class);
        api = new ApiController(service);
    }

    @Test
    public void getCurrency(){

        when(service.getCurrency()).thenReturn(buildMock());

        assertNotNull(api.getCurrency());
        assertEquals(HttpStatus.OK, api.getCurrency().getStatusCode());

    }

    public DataIntegration buildMock(){

        BTCIntegration btc = new BTCIntegration();
        EURIntegration eur = new EURIntegration();
        USDIntegration usd = new USDIntegration();

        return new DataIntegration().BTC(btc).EUR(eur).USD(usd);

    }

}
