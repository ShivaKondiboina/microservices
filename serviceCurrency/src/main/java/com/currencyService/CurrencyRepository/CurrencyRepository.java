package com.currencyService.CurrencyRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currencyService.CurrencyDetails.CurrencyDetails;

public interface CurrencyRepository extends JpaRepository<CurrencyDetails, Integer> {

	CurrencyDetails save(CurrencyDetails currencyDetails);

}
