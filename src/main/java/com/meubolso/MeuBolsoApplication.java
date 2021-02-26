package com.meubolso;

import com.meubolso.currency_api.ApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MeuBolsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuBolsoApplication.class, args);

	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Primary
	@Bean
	public ApiClient getCurrencyApi(RestTemplate restTemplate){

		return new ApiClient(restTemplate){
			@Override
			protected void init(){
				super.init();
				setBasePath("https://economia.awesomeapi.com.br/all/USD-BRL,EUR-BRL,BTC-BRL");
			}
		};
	}

}
