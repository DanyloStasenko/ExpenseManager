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
            System.out.println();
            System.out.print(">\t");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = reader.readLine();

            // Getting values from inputLine: [1]command, [2]date, [3]price, [4]currency, [5]title
            String[] inputValues = inputLine.split(" ", 5);
            String command = inputValues[0];

            switch (command) {
                case "add":
                    String date = inputValues[1];
                    double price = Double.parseDouble(inputValues[2]);
                    String currency = inputValues[3].toUpperCase();
                    String title = inputValues[4];

                    Purchase purchase = new Purchase(date, price, currency, title);
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
                    purchaseService.printTotal(inputValues[1].toUpperCase());
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
