package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Purchase;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class PurchaseService {
    private ArrayList<Purchase> list = new ArrayList<Purchase>();

    private ObjectMapper mapper;
    private ExchangeService service;

    public PurchaseService() throws Exception{
        mapper = new ObjectMapper();
        service = mapper.readValue(new URL("http://api.fixer.io/latest?base=EUR"), ExchangeService.class);
    }

    void add(Purchase purchase){
        if (purchase.getCurrency().equals("EUR")){
            purchase.setPriceInEur(purchase.getPrice());
        } else {
            double eurRate = service.getRate(purchase.getCurrency());
            purchase.setPriceInEur(purchase.getPrice() / eurRate);
        }

        list.add(purchase);
    }

    void deleteByDate(String date){
        ArrayList<Purchase> deleteCandidates = new ArrayList<Purchase>();

        for (Purchase purchase : list) {
            if (purchase.getDate().equals(date)){
                deleteCandidates.add(purchase);
            }
        }
        for (Purchase deleteCandidate : deleteCandidates) {
            list.remove(deleteCandidate);
        }
    }

    void printPurchaseList(){
        ArrayList<String> dates = new ArrayList<String>();
        for (Purchase purchase : list) {
            if (!dates.contains(purchase.getDate())){
                dates.add(purchase.getDate());
            }
        }

        for (String date : dates) {
            System.out.println();
            System.out.println(date);
            for (Purchase purchase : list) {
                if (date.equals(purchase.getDate())){
                    System.out.println(String.format("%s %.2f %s", purchase.getTittle(), purchase.getPrice(), purchase.getCurrency()));

                }
            }
        }
    }

    void sortPurchaseListByDate(){
        Collections.sort(list);
    }

    void getTotal(String currency){
        double eurSum = 0;
        for (Purchase purchase : list) {
            eurSum += purchase.getPriceInEur();
        }

        if (!currency.equals("EUR")){
            System.out.println(String.format("%.2f %s", eurSum * service.getRate(currency), currency));
        } else {
            System.out.println(String.format("%.2f EUR", eurSum));
        }
    }
}
