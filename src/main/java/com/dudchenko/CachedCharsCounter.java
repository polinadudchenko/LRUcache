package com.dudchenko;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharsCounter extends CharsCounterDecorator {

    private Map<String, Map<Character, Integer>> cache;

    public CachedCharsCounter(CharsCounter counter) {
        super(counter);
        cache = new LinkedHashMap<>();
    }

    @Override
    public Map<Character, Integer> countCharacters(String input) {
        return cache.computeIfAbsent(input, value -> super.countCharacters(input));
    }

}
