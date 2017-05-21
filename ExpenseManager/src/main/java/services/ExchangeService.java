package services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class ExchangeService {

    private String base;
    private String date;
    private HashMap<String, Double> rates;

    public static ExchangeService createInstance() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new URL("http://api.fixer.io/latest?base=EUR"), ExchangeService.class);
    }

    public Double getRate(String currency){
        if (!rates.containsKey(currency)){
            return -1d;
        }
        return rates.get(currency);
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

    public HashMap<String, Double> getRates() {
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
