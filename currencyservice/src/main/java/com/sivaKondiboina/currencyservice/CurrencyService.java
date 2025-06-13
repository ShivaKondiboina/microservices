package com.sivaKondiboina.currencyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import com.sivaKondiboina.Currencydetails.CurrencyDetails;
import com.sivaKondiboina.currencyrepository.CurrencyRepository;
import com.sivaKondiboina.feign.FeignClientCode;
import com.sivaKondiboina.requestCurrency.CurrencyRequest;


@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;
   

    @Autowired
    FeignClientCode feignClientCode;

    public CurrencyDetails save(CurrencyRequest currencyRequest) {
        CurrencyDetails currencyDetails = new CurrencyDetails();
        currencyDetails.setFromCurrency(currencyRequest.getFromCurrency());
        currencyDetails.setToCurrency(currencyRequest.getToCurrency());
        currencyDetails.setQuantity(currencyRequest.getQuantity());

        double conversionRate = FeignClient
                .getDetails(currencyRequest.getFromCurrency(), currencyRequest.getToCurrency())
                .getBody();

        double totalAmount = conversionRate * currencyRequest.getQuantity();
        currencyDetails.setConversionRate(conversionRate);
        currencyDetails.setTotalAmount(totalAmount);

        return currencyRepository.save(currencyDetails);
    }
}
