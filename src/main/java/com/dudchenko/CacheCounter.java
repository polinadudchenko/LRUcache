package com.dudchenko;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheCounter extends CounterDecorator {

    private Map<String, Map<Character, Integer>> map;
    private Cache cache = new Cache();

    public CacheCounter(ICounter counter) {
        super(counter);
        map = new LinkedHashMap<>();
    }

    @Override
    public Map<Character, Integer> countCharacters(String input) {
        map.computeIfAbsent(input, value -> super.countCharacters(input));
        cache.put(input, map.get(input));
        return cache.get(input);
    }

}
