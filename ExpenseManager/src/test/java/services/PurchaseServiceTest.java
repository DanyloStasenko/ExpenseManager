package services;

import model.Purchase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PurchaseServiceTest {

    @Test
    public void testAdd() throws Exception {
        PurchaseService purchaseService = new PurchaseService();

        purchaseService.add(new Purchase("2017-04-25", 21.35, "USD", "Jogurt"));
        purchaseService.add(new Purchase("2005-02-25", 60.3, "PLN", "Bananas"));
        purchaseService.add(new Purchase("2008-03-25", 39.99, "RUB", "Oranges"));
        purchaseService.add(new Purchase("2010-09-25", 2.01, "EUR", "Apples"));
        purchaseService.add(new Purchase("2003-01-25", 11.93, "BGN", "Water"));
    }

    @Test
    public void testDeleteByDate() throws Exception {
        PurchaseService purchaseService = new PurchaseService();

        purchaseService.add(new Purchase("2017-04-24", 21.35, "USD", "Jogurt"));
        purchaseService.add(new Purchase("2017-04-24", 21.35, "USD", "Jogurt"));
        purchaseService.add(new Purchase("2017-04-24", 21.35, "USD", "Jogurt"));

        int sizeBeforeDelete = purchaseService.getPurchases().size();

        purchaseService.add(new Purchase("2017-04-25", 60.3, "PLN", "Bananas"));
        purchaseService.add(new Purchase("2017-04-25", 39.99, "RUB", "Oranges"));
        purchaseService.add(new Purchase("2017-04-25", 2.01, "EUR", "Apples"));
        purchaseService.add(new Purchase("2017-04-25", 11.93, "BGN", "Water"));
        purchaseService.add(new Purchase("2017-04-25", 21.35, "USD", "Jogurt"));

        purchaseService.deleteByDate("2017-04-25");
        int sizeAfterDelete = purchaseService.getPurchases().size();
        assertEquals(sizeBeforeDelete, sizeAfterDelete);
    }

    @Test
    public void testPrintSortedList() throws Exception {
        PurchaseService purchaseService = new PurchaseService();

        purchaseService.add(new Purchase("2017-04-25", 2d, "USD", "Jogurt"));
        purchaseService.add(new Purchase("2017-04-25", 1.8, "EUR", "Jogurt"));
        purchaseService.add(new Purchase("2017-04-27", 7.3, "PLN", "Jogurt"));
        purchaseService.add(new Purchase("2017-04-29", 7.3, "PLN", "Jogurt"));
        purchaseService.add(new Purchase("2017-04-28", 7.3, "PLN", "Jogurt"));

        assertEquals(5, purchaseService.getPurchases().size());
    }

    @Test
    public void testGetTotal() throws Exception {
        PurchaseService purchaseService = new PurchaseService();

        purchaseService.add(new Purchase("2017-04-25", 2.3, "USD", "Jogurt"));
        purchaseService.add(new Purchase("2017-04-25", 1.8, "EUR", "Jogurt"));
        purchaseService.add(new Purchase("2017-04-25", 7.3, "PLN", "Jogurt"));

        purchaseService.printTotal("EUR");
        purchaseService.printTotal("PLN");
        purchaseService.printTotal("USD");
        purchaseService.printTotal("BGN");
    }
}