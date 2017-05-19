package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PurchaseTest {

    @Test
    public void testGetDate() throws Exception {
        assertEquals("2017-05-19", new Purchase("2017-05-19", 1d, "EUR", "Bananas").getDate());
    }

    @Test
    public void testSetDate() throws Exception {
        Purchase purchase = new Purchase("2000-00-00", 1d, "EUR", "Bananas");
        purchase.setDate("2017-05-19");
    }

    @Test
    public void testGetPrice() throws Exception {
        assertEquals(13, new Purchase("2017-05-19", 13d, "USD", "Bananas").getPrice(), 0);
    }

    @Test
    public void testSetPrice() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");
        purchase.setPrice(15);
    }

    @Test
    public void testGetCurrency() throws Exception {
        assertEquals("RUB", new Purchase("2017-05-19", 1d, "RUB", "Bananas").getCurrency());

    }

    @Test
    public void testSetCurrency() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");
        purchase.setCurrency("RUB");

    }

    @Test
    public void testGetTittle() throws Exception {
        assertEquals("Apples", new Purchase("2017-05-19", 1d, "EUR", "Apples").getTittle());
    }

    @Test
    public void testSetTittle() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");
        purchase.setTittle("Tittle Demo");
    }

    @Test
    public void testGetPriceInEur() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");
        purchase.setPriceInEur(10d);
        assertEquals(10, purchase.getPriceInEur(), 0);
    }

    @Test
    public void testSetPriceInEur() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");
        purchase.setPriceInEur(100d);
    }
}