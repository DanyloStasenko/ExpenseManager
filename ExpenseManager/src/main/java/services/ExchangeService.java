package services;

import java.util.Map;

public class ExchangeService {
    private String base;
    private String date;
    private Map<String, Double> rates;

    public Double getRate(String key){
        if (!rates.containsKey(key)){
            return -1d;
        }
        return rates.get(key);
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
