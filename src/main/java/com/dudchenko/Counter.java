package com.dudchenko;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Counter {

    public Map<String, Integer> getResult(String input, Cache cache) {
        if (!cache.contains(input)) {
            cache.put(input, countElements(input));
        }
        return cache.get(input);
    }

    private HashMap<String, Integer> countElements(String input) {
        HashMap<String, Integer> result = new LinkedHashMap<>();
        String[] chars = input.split("");
        for (String aChar : chars) {
            if (result.get(aChar) != null) {
                result.put(aChar, result.get(aChar) + 1);
            } else {
                result.put(aChar, 1);
            }
        }
        return result;
    }
}
