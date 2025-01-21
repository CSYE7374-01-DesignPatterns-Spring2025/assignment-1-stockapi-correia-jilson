package edu.neu.csye7374;

public abstract class StockAPI {
    protected String id;
    protected double price;
    protected String description;

    public StockAPI(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Stock[ID=%s, Price=%.2f, Description=%s]", id, price, description);
    }
}
