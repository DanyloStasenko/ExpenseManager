package services;

import java.util.Date;
import java.util.Map;

public class ExchangeService {
    private String base;
    private Date date;
    private Map<String, Double> rates;

    public Double getRate(String key){
        return rates.get(key);
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ExchangeService{" +
                "base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}
