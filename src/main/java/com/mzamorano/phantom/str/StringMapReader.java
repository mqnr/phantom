package com.mzamorano.phantom.str;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StringMapReader implements StringReader {
    private final Map<String, String> strings = new HashMap<>();

    public StringMapReader(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                String[] parts = line.split("=", 2);
                if (parts.length != 2) {
                    throw new RuntimeException("invalid entry in strings file");
                }
                strings.put(parts[0], parts[1]);

                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String read(String identifier) {
        return strings.get(identifier);
    }
}
