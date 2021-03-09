package io.swagger.configuration;

import com.meubolso.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;

public class Teste {




    public static void main(String[] args) {

        PriceService service = new PriceService();
        service.readPriceB3();


    }
}
