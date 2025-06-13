package com.currencyService.CurrencyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currencyService.CurrencyDetails.CurrencyDetails;
import com.currencyService.CurrencyRepository.CurrencyRepository;
import com.currencyService.CurrencyRequest.CurrencyRequest;
import com.currencyService.feign.feignclientcode;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class CurrencyService {
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	feignclientcode feignclientcode;

	@CircuitBreaker(name="currencyExchangeCB",fallbackMethod="getFallbackDetails")
	public CurrencyDetails save(CurrencyRequest currencyRequest) {
// double ConcersionRate=86.78;
		CurrencyDetails currencyDetails=new CurrencyDetails();
		currencyDetails.setFromcurrency(currencyRequest.getFromCurrency());
		currencyDetails.setTocurrency(currencyRequest.getToCurrency());
		currencyDetails.setQuantity(currencyRequest.getQuantity());
		
		double conversionRate=feignclientcode.getDetails(currencyRequest.getFromCurrency(),currencyRequest.getToCurrency()).getBody();
        double totalAmount= conversionRate*currencyRequest.getQuantity();
		currencyDetails.setTotalAmount(totalAmount);
		
		currencyDetails.setConversionRate(conversionRate);
		
		return  currencyRepository.save(currencyDetails);
	}
	
	public CurrencyDetails getFallbackDetails(CurrencyRequest currencyRequest,Throwable t) {
		/*
		 * CurrencyDetails currencyDetails=new CurrencyDetails();
		 * currencyDetails.setFromcurrency(currencyRequest.getFromCurrency());
		 * currencyDetails.setTocurrency(currencyRequest.getToCurrency());
		 * currencyDetails.setConversionRate(1.0);
		 * currencyDetails.setQuantity(currencyRequest.getQuantity());
		 * currencyDetails.setTotalAmount(1.0*currencyRequest.getQuantity()); return
		 * currencyDetails;
		 */
		
		throw new RuntimeException("Currency Exchange service down please try again later");
	}

}
