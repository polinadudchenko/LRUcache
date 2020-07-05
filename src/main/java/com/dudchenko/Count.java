package com.dudchenko;

import java.util.LinkedHashMap;

public class Count {

    public LinkedHashMap<String, Integer> countElements(String input) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();
        String[] chars = input.split("");
        for (int j = 0; j < chars.length; j++) {
            if (result.get(chars[j]) != null) {
                result.put(chars[j], result.get(chars[j]) + 1);
            } else {
                result.put(chars[j], 1);
            }
        }
        return result;
    }
}
