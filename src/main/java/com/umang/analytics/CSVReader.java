package com.umang.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {

    public static List<DataRecord> read(String path) throws IOException {

        return Files.lines(Paths.get(path))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new DataRecord(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2]),
                        Double.parseDouble(parts[3])
                ))
                .collect(Collectors.toList());
    }
}
