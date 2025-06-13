package com.sivaKondiboina.ExchangeController;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivaKondiboina.CurrencyExchange.CurrencyExchange;
import com.sivaKondiboina.ExchangeRepository.ExchangeRepository;




@RestController
@RequestMapping("/api/v1")
public class ExchangeController {


		@Autowired
		ExchangeRepository exchangeRepository;
		
		@GetMapping("/from/{fromCurrency}/to/{toCurrency}")
		public ResponseEntity<Double> getDetails(@PathVariable("fromCurrency") String fromCurrency,@PathVariable("toCurrency") String toCurrency)
		{
		 Optional<CurrencyExchange> optionalCurrencyExchange=exchangeRepository.findByFromCurrencyAndToCurrency(fromCurrency,toCurrency);
			
		if(optionalCurrencyExchange.isPresent())
		{
			 return ResponseEntity.status(HttpStatus.CREATED)
					              .header("info", "retrived successfully..")
					              .body(optionalCurrencyExchange.get().getConversionRate());
		}
		else 
		{
			return ResponseEntity.status(HttpStatus.OK)
					              .header("info","retrived successfully..")
					              .body(0.0);
		}
	       
	}	
		

}