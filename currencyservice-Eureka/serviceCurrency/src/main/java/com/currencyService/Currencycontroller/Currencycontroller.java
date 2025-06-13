package com.currencyService.Currencycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currencyService.CurrencyDetails.CurrencyDetails;
import com.currencyService.CurrencyRequest.CurrencyRequest;
import com.currencyService.CurrencyService.CurrencyService;

@RestController
@RequestMapping("/api/v1")
public class Currencycontroller {
	@Autowired
	CurrencyService currencyService;
	@PostMapping("/currency")
	public ResponseEntity<CurrencyDetails>getCurrencyDetails(@RequestBody CurrencyRequest currencyRequest)
	{
		CurrencyDetails saveDetails = currencyService.save(currencyRequest);
		return ResponseEntity.status(HttpStatus.CREATED)
				             .header("info", "data saved successfully")
				             .body(saveDetails);
		
	}
	

}
