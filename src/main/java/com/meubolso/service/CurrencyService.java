package com.meubolso.service;

import com.meubolso.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    CurrencyRepository repo;

    public Object getCurrency(){
        return repo.getCurrency();

    }

}
