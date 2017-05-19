package services;

import model.Purchase;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class PurchaseServiceTest {

    @Test
    public void testGetList() throws Exception {
        PurchaseService purchaseService = new PurchaseService();
        purchaseService.add(new Purchase("2017-04-25", 2d, "EUR", "Jogurt"));
        purchaseService.add(new Purchase("2017-04-26", 4d, "EUR", "Apple"));

        assertEquals(2, purchaseService.getList().size());
    }

    @Test
    public void testSetList() throws Exception {
        ArrayList<Purchase> list = new ArrayList<Purchase>();
        list.add(new Purchase("2017-04-25", 2d, "EUR", "Jogurt"));
        list.add(new Purchase("2017-04-26", 4d, "EUR", "Apple"));

        PurchaseService purchaseService = new PurchaseService();
        purchaseService.setList(list);
    }

    @Test
    public void testAdd() throws Exception {
        PurchaseService purchaseService = new PurchaseService();
        purchaseService.add(new Purchase("2017-04-25", 2d, "EUR", "Jogurt"));
    }

    @Test
    public void testDeleteByDate() throws Exception {
        ArrayList<Purchase> list = new ArrayList<Purchase>();
        list.add(new Purchase("2017-04-25", 2d, "EUR", "Jogurt"));
        list.add(new Purchase("2017-04-25", 2d, "EUR", "Jogurt"));
        list.add(new Purchase("2017-04-25", 2d, "EUR", "Jogurt"));
        list.add(new Purchase("2017-04-25", 2d, "EUR", "Jogurt"));
        list.add(new Purchase("2017-04-26", 4d, "EUR", "Apple"));
        list.add(new Purchase("2017-04-27", 4d, "EUR", "Apple"));

        PurchaseService purchaseService = new PurchaseService();
        purchaseService.setList(list);

        assertEquals(6, purchaseService.getList().size(), 0);

        purchaseService.deleteByDate("2017-04-25");
        assertEquals(2, purchaseService.getList().size(), 0);
    }

    @Test
    public void testPrintPurchaseList() throws Exception {

    }

    @Test
    public void testGetTotal() throws Exception {

    }
}