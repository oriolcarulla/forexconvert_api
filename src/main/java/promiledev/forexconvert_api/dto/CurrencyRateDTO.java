package promiledev.forexconvert_api.dto;

import java.math.BigDecimal;

public class CurrencyRateDTO {
    private String currency;
    private BigDecimal rate;

    public CurrencyRateDTO(String currency, BigDecimal rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }
    public BigDecimal getRate() {
        return rate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}
