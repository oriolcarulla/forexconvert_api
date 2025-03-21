package promiledev.forexconvert_api.response;

import java.math.BigDecimal;

public class ExchangeResponse {
    private String from;
    private String to;
    private BigDecimal amount;
    private BigDecimal rate;
    private BigDecimal result;

    public ExchangeResponse(String from, String to, BigDecimal amount, BigDecimal rate, BigDecimal result) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.rate = rate;
        this.result = result;
    }

    // Getters and setters
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public BigDecimal getRate() {
        return rate;
    }
    public BigDecimal getResult() {
        return result;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
    public void setResult(BigDecimal result) {
        this.result = result;
    }

}
