package com.dudchenko;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Counter {

    public Map<String, Integer> getResult(String input, Cache cache) {
        if (!cache.contains(input)) {
            cache.put(input, countCharacters(input));
        }
        return cache.get(input);
    }

    private Map<String, Integer> countCharacters(String input) {
        HashMap<String, Integer> result = new LinkedHashMap<>();
        String[] chars = input.split("");
        for (String symbol : chars) {
            if (result.get(symbol) != null) {
                result.put(symbol, result.get(symbol) + 1);
            } else {
                result.put(symbol, 1);
            }
        }
        return result;
    }
}

