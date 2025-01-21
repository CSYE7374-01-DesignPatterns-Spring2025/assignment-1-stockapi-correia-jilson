package edu.neu.csye7374;

public class ValueStock extends StockAPI implements Tradable {
    private int metric;
    private int totalBids;

    public ValueStock(String id, double price, String description) {
        super(id, price, description);
        this.metric = 0;
        this.totalBids = 0;
    }

    @Override
    public void setBid(String bid) {
        String[] bidParts = bid.split(":");
        String action = bidParts[0];
        int amount = Integer.parseInt(bidParts[1]);

        if (action.equalsIgnoreCase("BUY")) {
            this.price += amount * 0.05;
            this.metric += amount * 2;
        } else if (action.equalsIgnoreCase("SELL")) {
            this.price -= amount * 0.05;
            this.metric -= amount * 2;
        }
        totalBids++;
    }

    @Override
    public int getMetric() {
        return metric / (totalBids > 0 ? totalBids : 1);
    }
}

