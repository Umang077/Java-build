package com.umang.intuit.analytics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsService {

    private final List<DataRecord> records;

    public AnalyticsService(List<DataRecord> records) {
        this.records = records;
    }

    public Map<String, Double> revenueByRegion() {
        return records.stream()
                .collect(Collectors.groupingBy(
                        DataRecord::getRegion,
                        Collectors.summingDouble(DataRecord::getRevenue)
                ));
    }

    public Map<String, Long> countByCategory() {
        return records.stream()
                .collect(Collectors.groupingBy(
                        DataRecord::getCategory,
                        Collectors.counting()
                ));
    }
}
