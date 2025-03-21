package promiledev.forexconvert_api.controller;

import promiledev.forexconvert_api.model.Rate;
import promiledev.forexconvert_api.repository.RateRepository;
import promiledev.forexconvert_api.response.ExchangeResponse;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rates")
public class RatesController {
    private final RateRepository rateRepository;

    public RatesController(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @GetMapping
    public List<Rate> getRates() {
        return rateRepository.findAll();
    }
}
