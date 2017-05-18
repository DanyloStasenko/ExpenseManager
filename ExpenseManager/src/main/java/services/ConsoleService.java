package services;

import model.Purchase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleService  {

    public static void main(String[] args) throws Exception {

        // TODO: unit - tests

        PurchaseService purchaseService = new PurchaseService();

        while (true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = reader.readLine();

            String[] input = inputLine.split(" ", 5);
            String command = input[0];

            if (command.equals("add")){
                Purchase purchase = new Purchase(input[1], Double.parseDouble(input[2]), input[3], input[4]);

                purchaseService.add(purchase);
                purchaseService.printPurchaseList();
            }

            if (command.equals("list")){
                purchaseService.sortPurchaseListByDate();
                purchaseService.printPurchaseList();
            }

            if (command.equals("clear")){
                String dateToDelete = input[1];
                purchaseService.deleteByDate(dateToDelete);
            }

            if (command.equals("total")){
                purchaseService.getTotal(input[1]);
            }

            if (command.equals("exit")){
                break;
            }
        }
    }
}

/*
Testing:
add 2017-04-25 2 USD Jogurt
add 2017-04-25 3 EUR “French fries”
add 2017-04-25 2000 PLN Car
add 2017-04-26 2000 USD Something
total USD
clear 2017-04-25
add 2017-04-26 2000 USD Something
total EUR
*/