package com.umang.intuit.analytics;

public class DataRecord {

    private final String category;
    private final String region;
    private final int sales;
    private final double revenue;

    public DataRecord(String category, String region, int sales, double revenue) {
        this.category = category;
        this.region = region;
        this.sales = sales;
        this.revenue = revenue;
    }

    public String getCategory() { return category; }
    public String getRegion() { return region; }
    public int getSales() { return sales; }
    public double getRevenue() { return revenue; }
}
