package services;

import java.util.HashMap;
import java.util.Map;

public class ExchangeService {
    private String base = "EUR";
    private String date = "2017-05-20";
    private HashMap<String, Double> rates;

    public void addRate(String currency, Double rate){
        rates.put(currency, rate);
    }

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

    public void setRates(HashMap<String, Double> rates) {
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
