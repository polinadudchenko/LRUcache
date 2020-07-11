package com.dudchenko;

import java.util.Iterator;
import java.util.Map;

public class OutputFormatter {

    public static String format(Map<String, Integer> result) {
        StringBuilder output = new StringBuilder();
        Iterator iterator = result.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            output.append("\"");
            output.append(pair.getKey());
            output.append("\"");
            output.append(" - ");
            output.append(pair.getValue());
            output.append(System.lineSeparator());
        }
        return output.toString();
    }
}
