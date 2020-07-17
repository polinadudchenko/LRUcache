package com.dudchenko;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cache {

    private Map<String, Map<Character, Integer>> cacheMap = new HashMap<>();
    private static final int cacheCapacity = 5;

    public Map<Character, Integer> get(String key) {
        if (cacheMap.get(key) == null) {
            return null;
        } else {
            Map<Character, Integer> node = cacheMap.get(key);
            cacheMap.keySet().removeIf(mapKey -> mapKey == key);
            cacheMap.put(key, node);
            return cacheMap.get(key);
        }
    }

    public void put(String key, Map<Character, Integer> value) {
        if (cacheMap.containsKey(key)) {
            Map<Character, Integer> node = cacheMap.get(key);
            cacheMap.keySet().removeIf(mapKey -> mapKey == key);
            cacheMap.put(key, node);
        } else {
            if (cacheMap.size() == cacheCapacity) {
                cacheMap.remove(headNode.getNodeKey());
                removeNode(headNode);
            }
            Map<Character, Integer> node = new Node(key, value);
            addNode(node);
            cacheMap.put(key, node);
        }
    }

    public boolean contains(String key) {
        return cacheMap.containsKey(key);
    }

}

