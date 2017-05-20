package app;

import model.Purchase;
import services.PurchaseService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppRunner {

    public static void main(String[] args) throws Exception {

        PurchaseService purchaseService = new PurchaseService();

        boolean exit = false;
        while (!exit) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = reader.readLine();

            String[] inputValues = inputLine.split(" ", 5);
            String command = inputValues[0];

            switch (command) {
                case "add":
                    Purchase purchase = new Purchase(inputValues[1], Double.parseDouble(inputValues[2]), inputValues[3], inputValues[4]);
                    purchaseService.add(purchase);
                    purchaseService.printSortedList();
                    break;

                case "list":
                    purchaseService.printSortedList();
                    break;

                case "clear":
                    purchaseService.deleteByDate(inputValues[1]);
                    purchaseService.printSortedList();
                    break;

                case "total":
                    purchaseService.getTotal(inputValues[1]);
                    break;

                case "exit":
                    exit = true;
                    break;

                default:
                    System.err.println("Unrecognized command: " + command);
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