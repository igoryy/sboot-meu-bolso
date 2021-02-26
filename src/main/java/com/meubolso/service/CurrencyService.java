package com.meubolso.service;

import com.meubolso.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRepository repo;

    public Object getCurrency(){
        return repo.getCurrency();

    }

}
