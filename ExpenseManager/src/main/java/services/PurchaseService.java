package services;

import model.Purchase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class PurchaseService {

    private ExchangeService exchangeService;
    private ArrayList<Purchase> purchases = new ArrayList<>();

    public PurchaseService() throws IOException{
        exchangeService = ExchangeService.createInstance();
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void add(Purchase purchase){
        if (purchase.getCurrency().equals("EUR")){
            purchase.setPriceInEur(purchase.getPrice());
        } else {
            double eurRate = exchangeService.getRate(purchase.getCurrency());
            purchase.setPriceInEur(purchase.getPrice() / eurRate);
        }

        purchases.add(purchase);
    }

    public void deleteByDate(String date){
        purchases.removeIf(purchase -> purchase.getDate().equals(date));
    }

    public void printSortedList(){
        // Sorting by Date
        Collections.sort(purchases);

        ArrayList<String> dates = new ArrayList<>();
        purchases.stream().filter(purchase -> !dates.contains(purchase.getDate())).forEach(purchase -> dates.add(purchase.getDate()));

        for (String date : dates) {
            System.out.println();
            System.out.println(date);
            purchases.stream().filter(purchase -> date.equals(purchase.getDate())).
                    forEach(purchase -> System.out.println(String.format("%s %.2f %s",
                            purchase.getTittle(), purchase.getPrice(), purchase.getCurrency())));
        }
    }

    public void printTotal(String currency){
        double eurSum = 0;
        for (Purchase purchase : purchases) {
            eurSum += purchase.getPriceInEur();
        }

        if (!currency.equals("EUR")){
            System.out.println(String.format("%.2f %s", eurSum * exchangeService.getRate(currency), currency));
        } else {
            System.out.println(String.format("%.2f EUR", eurSum));
        }
        System.out.println();
    }

}
