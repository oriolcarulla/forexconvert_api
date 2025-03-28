package promiledev.forexconvert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import promiledev.forexconvert_api.dto.CurrencyRateDTO;
import promiledev.forexconvert_api.model.Rate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Long> {
    Optional<Rate> findByUsdAndCurrency(String usd, String currency);
    Optional<Rate> findByCurrency(String currency);
    @Query("SELECT new promiledev.forexconvert_api.dto.CurrencyRateDTO(r.currency, r.rate) FROM Rate r WHERE r.currency <> :currency")
    List<CurrencyRateDTO> getCurrencyList(@Param("currency") String currency);
    @Query("SELECT r.currency FROM Rate as r")
    List<String> getCurrencyList();

}
