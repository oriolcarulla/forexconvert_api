package promiledev.forexconvert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import promiledev.forexconvert_api.model.Rate;

import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Long> {
    Optional<Rate> findByUsdAndCurrency(String usd, String currency);
    Optional<Rate> findByCurrency(String currency);
}
