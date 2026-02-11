package com.umang.analytics;

import java.io.IOException;
import java.util.List;

public class AnalyticsApplication {

    public static void main(String[] args) throws IOException {

        List<DataRecord> records =
                CSVReader.read("src/main/resources/sample.csv");

        AnalyticsService service = new AnalyticsService(records);

        System.out.println("Revenue By Region:");
        System.out.println(service.revenueByRegion());

        System.out.println("Count By Category:");
        System.out.println(service.countByCategory());
    }
}
