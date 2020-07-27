package com.dudchenko;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharsCounter implements CharsCounter {

    @Override
    public Map<Character, Integer> countCharacters(String input) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Integer value = result.getOrDefault(input.charAt(i), 0);
            result.put(input.charAt(i), value + 1);
        }
        return result;
    }
}

