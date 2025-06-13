package com.sivaKondiboina.currencyrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sivaKondiboina.Currencydetails.CurrencyDetails;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyDetails, Long> {
 
}
