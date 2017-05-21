package services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;

public class ExchangeServiceTest {

    @Test
    public void testGetRate() throws Exception {
        ExchangeService service = ExchangeService.createInstance();
        assertEquals(service.getRate("RUB"), 60.0, 7.0);
        assertEquals(service.getRate("USD"), 1, 0.2);
    }

    @Test
    public void testGetBase() throws Exception {
        ExchangeService service = ExchangeService.createInstance();
        assertEquals(service.getBase(), "EUR");

        service.setBase("USD");
        assertEquals(service.getBase(), "USD");

        service.setBase("RUB");
        assertEquals(service.getBase(), "RUB");
    }

    @Test
    public void testSetBase() throws Exception {
        ExchangeService service = ExchangeService.createInstance();
        service.setBase("USD");
        assertEquals(service.getBase(), "USD");

        service.setBase("RUB");
        assertEquals(service.getBase(), "RUB");
    }

    @Test
    public void testGetDate() throws Exception {
        ExchangeService service = ExchangeService.createInstance();
        assertEquals(service.getDate(), "2017-05-19");
    }

    @Test
    public void testSetDate() throws Exception {
        ExchangeService service = ExchangeService.createInstance();
        service.setDate("2017-05-19");
        assertEquals(service.getDate(), "2017-05-19");

        service.setDate("2017-05-21");
        assertEquals(service.getDate(), "2017-05-21");

        service.setDate("2017-05-22");
        assertEquals(service.getDate(), "2017-05-22");
    }

    @Test
    public void testGetRates() throws Exception {
        ExchangeService service = ExchangeService.createInstance();
        assertEquals(false, service.getRates().isEmpty());
    }

    @Test
    public void testSetRates() throws Exception {
        ExchangeService service = ExchangeService.createInstance();

        HashMap<String, Double> rates = service.getRates();
        rates.put("UAH", 0.3);

        service.setRates(rates);

        assertEquals (0.3, service.getRate("UAH"), 0);
    }
}