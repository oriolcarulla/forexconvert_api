package promiledev.forexconvert_api.controller;

import org.springframework.http.ResponseEntity;
import promiledev.forexconvert_api.dto.CurrencyRateDTO;
import promiledev.forexconvert_api.model.Rate;
import promiledev.forexconvert_api.repository.RateRepository;
import promiledev.forexconvert_api.response.ExchangeResponse;




import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rate")
public class RateController {
    private final RateRepository rateRepository;

    public RateController(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @PostMapping
    public Rate createRate(@RequestBody Rate rate) {
        return rateRepository.save(rate);
    }

    @GetMapping
    public ResponseEntity<?> getExchangeRate(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount){

        // Try to find direct rate
        Optional<Rate> directRateOpt = rateRepository.findByUsdAndCurrency(from, to);
        if (directRateOpt.isPresent()){
            BigDecimal rate = directRateOpt.get().getRate();
            BigDecimal result = amount.multiply(rate);
            return ResponseEntity.ok(new ExchangeResponse (from, to, amount, rate, result));
        }

        Optional<Rate> fromToUsdOpt = rateRepository.findByCurrency(from);
        Optional<Rate> usdToToOpt = rateRepository.findByUsdAndCurrency("usd", to);

        if (fromToUsdOpt.isPresent() && usdToToOpt.isPresent()){
            BigDecimal fromToUsd = BigDecimal.ONE.divide(fromToUsdOpt.get().getRate(), 4, RoundingMode.HALF_UP);
            BigDecimal usdToTo = usdToToOpt.get().getRate();
            BigDecimal rate = fromToUsd.multiply(usdToTo);
            BigDecimal result = amount.multiply(rate);

            return ResponseEntity.ok(new ExchangeResponse(from, to, amount, rate, result));

        }
        return ResponseEntity.badRequest().body("No exchange rate found for " + from + " to " + to);
    }

    @GetMapping("/{currency}")
    public ResponseEntity<?> getRatesForCurrency(@PathVariable String currency){
        //Si la moneda es USD, devolver todos los rates
        if (currency.equals("usd")){
            List<Rate> rates = rateRepository.findAll();
            return ResponseEntity.ok(rates);
        }

        BigDecimal targetRate = BigDecimal.ONE;
        Optional<Rate> rateOpt = rateRepository.findByCurrency(currency);
        if (rateOpt.isPresent()){
            targetRate = rateOpt.get().getRate();
        } else {
            return ResponseEntity.badRequest().body("No exchange rate found for " + currency);
        }

        List<CurrencyRateDTO> currencyRateDTOList = rateRepository.getCurrencyList(currency);
        for (CurrencyRateDTO item : currencyRateDTOList){
            item.setRate(item.getRate().divide(targetRate, 4, RoundingMode.HALF_UP));
        }
        return ResponseEntity.ok(currencyRateDTOList);

    }


}