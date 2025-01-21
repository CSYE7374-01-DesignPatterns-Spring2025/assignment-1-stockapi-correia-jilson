package edu.neu.csye7374;

public class CalculateStock {

    private static CalculateStock instance = null;

    private CalculateStock() {
    }

    // Lazy singleton class instance with thread safety double check with and without synchronization
    public static CalculateStock getInstance() {
        if (instance == null) {
            synchronized (CalculateStock.class) {
                if (instance == null) {
                    instance = new CalculateStock();
                }
            }
        }
        return instance;
    }


    public void calculateStock() {
        // Create instances of both stock types
        GrowthStock growthStock = new GrowthStock("GROW1", 100.0, "High growth potential stock");
        ValueStock valueStock = new ValueStock("VAL1", 50.0, "Undervalued stock");

        // Array of bids for simulation
        String[] bids = {"BUY:10", "SELL:5", "BUY:15", "SELL:10", "BUY:20", "SELL:25"};

        // Simulate bids on GrowthStock
        System.out.println("Simulating GrowthStock:");
        for (String bid : bids) {
            growthStock.setBid(bid);
            System.out.printf("After bid %s: Price = %.2f, Metric = %d\n", bid, growthStock.price, growthStock.getMetric());
        }

        // Simulate bids on ValueStock
        System.out.println("\nSimulating ValueStock:");
        for (String bid : bids) {
            valueStock.setBid(bid);
            System.out.printf("After bid %s: Price = %.2f, Metric = %d\n", bid, valueStock.price, valueStock.getMetric());
        }
    }
}
