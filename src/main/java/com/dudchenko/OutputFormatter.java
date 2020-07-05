package com.dudchenko;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutputFormatter {

    public static String format(LinkedHashMap<String, Integer> result){
        StringBuilder output = new StringBuilder();
        Iterator it = result.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            output.append("\"");
            output.append(pair.getKey());
            output.append("\"");
            output.append(" - ");
            output.append(pair.getValue());
            output.append(System.lineSeparator());
            it.remove(); // avoids a ConcurrentModificationException
        }
        return output.toString();
    }
}
