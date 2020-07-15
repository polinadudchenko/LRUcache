package com.dudchenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CacheTest {

    private Cache cache;

    @Mock
    private Cache mockCache;

    @BeforeEach
    private void setUp() {
        cache = new Cache();
    }

    @Test
    public void givenNullKey_whenGet_thenNull() {
        assertNull(cache.get("Hello"));
    }

    @Test
    public void givenKey_whenGet_thenReturnMap() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("h", 1);
        expected.put("i", 1);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("h", 1);
        map.put("i", 1);
        cache.put("hi", map);

        assertEquals(expected, cache.get("hi"));
    }

    @Test
    public void givenParametersToPut_whenPut_thenPutExecuted() {

        Cache mockCache = Mockito.spy(Cache.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("h", 1);
        map.put("i", 1);
        mockCache.put("hi", map);

        Mockito.verify(mockCache, Mockito.times(1)).put("hi", map);

    }
}
