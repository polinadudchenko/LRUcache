package com.dudchenko;

import java.util.LinkedHashMap;
import java.util.Map;

public class Counter implements ICounter {

    @Override
    public Map<Character, Integer> countCharacters(String input) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (result.get(input.charAt(i)) != null) {
                result.put(input.charAt(i), result.get(input.charAt(i)) + 1);
            } else {
                result.put(input.charAt(i), 1);
            }
        }
        return result;
    }
}

