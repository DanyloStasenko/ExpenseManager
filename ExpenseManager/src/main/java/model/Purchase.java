package model;

public class Purchase implements Comparable<Purchase> {

    private String date;
    private String currency;
    private String tittle;
    private double price;
    private double priceInEur;      // simplifying calculations with this additional variable

    public Purchase(String date, double price, String currency, String tittle) {
        this.date = date;
        this.setPrice(price);
        this.currency = currency;
        this.tittle = tittle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        } else {
            throw new RuntimeException("Price must be greater than 0!");
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Double getPriceInEur() {
        return priceInEur;
    }

    public void setPriceInEur(Double priceInEur) {
        this.priceInEur = priceInEur;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "date='" + date + '\'' +
                ", currency='" + currency + '\'' +
                ", tittle='" + tittle + '\'' +
                ", price=" + price +
                ", priceInEur=" + priceInEur +
                '}';
    }

    @Override
    public int compareTo(Purchase otherPurchase) {
        return this.getDate().compareTo(otherPurchase.getDate());
    }
}

