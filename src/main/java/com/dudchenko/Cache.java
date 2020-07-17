package com.dudchenko;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Cache {

    private Map<String, Map<Character, Integer>> cacheMap = new LinkedHashMap<>();
    private static final int cacheCapacity = 5;

    public Map<Character, Integer> get(String key) {
        if (cacheMap.get(key) == null) {
            return null;
        } else {
            Map<Character, Integer> node = cacheMap.get(key);
            cacheMap.remove(key);
            cacheMap.put(key, node);
            return cacheMap.get(key);
        }
    }

    public void put(String key, Map<Character, Integer> value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key);
        } else if (cacheMap.size() == cacheCapacity) {
                cacheMap.remove(cacheMap.keySet().iterator().next());
            }
        cacheMap.put(key, value);
    }

    public boolean contains(String key) {
        return cacheMap.containsKey(key);
    }

}

