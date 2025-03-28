package promiledev.forexconvert_api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import promiledev.forexconvert_api.repository.RateRepository;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final RateRepository rateRepository;

    public CurrencyController(RateRepository rateRepository){
        this.rateRepository = rateRepository;
    }

        @GetMapping
        public ResponseEntity<?> getCurrency(){
            List<String> currencyList = rateRepository.getCurrencyList();
            return ResponseEntity.ok(currencyList);
        }
}
