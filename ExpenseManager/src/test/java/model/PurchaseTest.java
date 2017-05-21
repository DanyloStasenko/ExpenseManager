package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PurchaseTest {

    @Test
    public void testGetDate() throws Exception {
        assertEquals("2017-05-19", new Purchase("2017-05-19", 1d, "EUR", "Bananas").getDate());
        assertEquals("2017-04-25", new Purchase("2017-04-25", 39.99, "RUB", "Oranges").getDate());
        assertEquals("2017-04-25", new Purchase("2017-04-25", 2.01, "EUR", "Apples").getDate());
        assertEquals("2017-04-25", new Purchase("2017-04-25", 11.93, "BGN", "Water").getDate());
        assertEquals("2017-05-12", new Purchase("2017-05-12", 11.34, "EUR", "Something").getDate());
        assertEquals("2017-05-13", new Purchase("2017-05-13", 15.42, "EUR", "Pizza").getDate());
        assertEquals("2017-05-14", new Purchase("2017-05-14", 15.11, "EUR", "Bread").getDate());
        assertEquals("2017-05-15", new Purchase("2017-05-15", 0.24, "EUR", "Coca-Cola").getDate());
    }

    @Test
    public void testSetDate() throws Exception {
        Purchase purchase = new Purchase("2000-00-00", 1d, "EUR", "Bananas");
        purchase.setDate("2017-05-19");
        purchase.setDate("2017-05-12");
        purchase.setDate("2017-05-13");
        purchase.setDate("2017-05-14");
        purchase.setDate("2017-05-15");
        purchase.setDate("2017-05-16");
    }

    @Test
    public void testGetPrice() throws Exception {
        assertEquals(13.1, new Purchase("2017-05-19", 13.1, "USD", "Bananas").getPrice(), 0);
        assertEquals(14.2, new Purchase("2017-05-19", 14.2, "USD", "Bananas").getPrice(), 0);
        assertEquals(15.3, new Purchase("2017-05-19", 15.3, "USD", "Bananas").getPrice(), 0);
        assertEquals(16.5, new Purchase("2017-05-19", 16.5, "USD", "Bananas").getPrice(), 0);
        assertEquals(17.2, new Purchase("2017-05-19", 17.2, "USD", "Bananas").getPrice(), 0);
        assertEquals(18.99, new Purchase("2017-05-19", 18.99, "USD", "Bananas").getPrice(), 0);
    }

    @Test
    public void testSetPrice() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");
        purchase.setPrice(15);
        purchase.setPrice(16.32);
        purchase.setPrice(12.11);
        purchase.setPrice(3.99);
        purchase.setPrice(0.1);
    }

    @Test
    public void testGetCurrency() throws Exception {
        assertEquals("RUB", new Purchase("2017-05-19", 1d, "RUB", "Bananas").getCurrency());
        assertEquals("USD", new Purchase("2017-05-19", 1d, "USD", "Bananas").getCurrency());
        assertEquals("PLN", new Purchase("2017-05-19", 1d, "PLN", "Bananas").getCurrency());
        assertEquals("BGN", new Purchase("2017-05-19", 1d, "BGN", "Bananas").getCurrency());
        assertEquals("EUR", new Purchase("2017-05-19", 1d, "EUR", "Bananas").getCurrency());
    }

    @Test
    public void testSetCurrency() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");

        purchase.setCurrency("RUB");
        purchase.setCurrency("USD");
        purchase.setCurrency("PLN");
        purchase.setCurrency("BGN");
        purchase.setCurrency("EUR");
    }

    @Test
    public void testGetTittle() throws Exception {
        assertEquals("Apples", new Purchase("2017-05-19", 1d, "EUR", "Apples").getTittle());
        assertEquals("Bananas", new Purchase("2017-05-19", 1d, "EUR", "Bananas").getTittle());
        assertEquals("Water", new Purchase("2017-05-19", 1d, "EUR", "Water").getTittle());
        assertEquals("Pizza", new Purchase("2017-05-19", 1d, "EUR", "Pizza").getTittle());
        assertEquals("Sweets", new Purchase("2017-05-19", 1d, "EUR", "Sweets").getTittle());
        assertEquals("Oranges", new Purchase("2017-05-19", 1d, "EUR", "Oranges").getTittle());
    }

    @Test
    public void testSetTittle() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");

        purchase.setTittle("Apples");
        purchase.setTittle("Bananas");
        purchase.setTittle("Water");
        purchase.setTittle("Pizza");
        purchase.setTittle("Sweets");
        purchase.setTittle("Oranges");
    }

    @Test
    public void testGetPriceInEur() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");

        purchase.setPriceInEur(10d);
        assertEquals(10, purchase.getPriceInEur(), 0);
        purchase.setPriceInEur(11.3);
        assertEquals(11.3, purchase.getPriceInEur(), 0);
        purchase.setPriceInEur(0.99);
        assertEquals(0.99, purchase.getPriceInEur(), 0);
    }

    @Test
    public void testSetPriceInEur() throws Exception {
        Purchase purchase = new Purchase("2017-05-19", 1d, "EUR", "Bananas");

        purchase.setPriceInEur(100d);
        purchase.setPriceInEur(0.01);
        purchase.setPriceInEur(0.99);
        purchase.setPriceInEur(0.52);
        purchase.setPriceInEur(34.99);
    }
}