package edu.neu.csye7374;

public class GrowthStock extends StockAPI implements Tradable {
    private int metric;
    private int bidCount;

    public GrowthStock(String id, double price, String description) {
        super(id, price, description);
        this.metric = 0;
        this.bidCount = 0;
    }

    @Override
    public void setBid(String bid) {
        String[] bidParts = bid.split(":");
        String action = bidParts[0];
        int amount = Integer.parseInt(bidParts[1]);

        if (action.equalsIgnoreCase("BUY")) {
            this.price += amount * 0.1;
            this.metric += amount;
        } else if (action.equalsIgnoreCase("SELL")) {
            this.price -= amount * 0.1;
            this.metric -= amount;
        }
        bidCount++;
    }

    @Override
    public int getMetric() {
        return metric + bidCount;
    }
}
