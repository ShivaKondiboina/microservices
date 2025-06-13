package com.sivaKondiboina.ExchangeRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivaKondiboina.CurrencyExchange.CurrencyExchange;

public interface ExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	Optional<CurrencyExchange> findByFromCurrencyAndToCurrency(String from, String to);

}
