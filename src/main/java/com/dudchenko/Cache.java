package com.dudchenko;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache {

    private Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();
    private static final int cacheCapacity = 5;

    public Map<Character, Integer> get(String key) {
        if (cache.get(key) == null) {
            return null;
        } else {
            Map<Character, Integer> node = cache.get(key);
            cache.remove(key);
            cache.put(key, node);
            return cache.get(key);
        }
    }

    public void put(String key, Map<Character, Integer> value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if (cache.size() == cacheCapacity) {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(key, value);
    }

    public boolean contains(String key) {
        return cache.containsKey(key);
    }
}
