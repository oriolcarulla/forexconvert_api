package promiledev.forexconvert_api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usd;
    private String currency;
    @Column(name = "rate", precision = 10, scale = 4)
    private BigDecimal rate;


    public Long getId() {
        return id;
    }
    public String getUsd() {
        return usd;
    }
    public String getCurrency() {
        return currency;
    }
    public BigDecimal getRate() {
        return rate;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUsd(String usd) {
        this.usd = usd;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
