 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivaKondiboina.Currencydetails.CurrencyDetails;
import com.sivaKondiboina.currencyservice.CurrencyService;
import com.sivaKondiboina.requestCurrency.CurrencyRequest;



@RestController
@RequestMapping("/api/v1")
public class CurrencyController 
{
	@Autowired
	 CurrencyService currencyService;
	
 @PostMapping("/Currency")
 public ResponseEntity<CurrencyDetails> getCurrencyDetails(@RequestBody CurrencyRequest currencyRequest) 
 { 
	 CurrencyDetails saveDetails=currencyService.save(currencyRequest);
	 
     return ResponseEntity.status(HttpStatus.CREATED)
    		               .header("info","Data save Succesfully..")
    		               .body(saveDetails);
 }
 
}