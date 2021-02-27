package com.meubolso.service;

import com.meubolso.currency_api.DataIntegration;
import com.meubolso.domain.CurrencyDomain;
import com.meubolso.exception.CurrencyException;
import com.meubolso.provider.presentation.representation.DataRepresentation;
import com.meubolso.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CurrencyService {

    private final CurrencyRepository repo;

    public DataIntegration getCurrency()  {

        try{

            var responseApi = repo.getCurrency();
            return responseApi;
        }catch (Exception e){
            log.error("Erro ao obter currency ", e );
            return new DataIntegration();
        }

    }

}
