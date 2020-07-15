package com.dudchenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    private Counter counter;

    @BeforeEach
    private void setUp() {
        counter = new Counter();
    }

    @Test
    public void givenEmptyString_whenCountElements_thenMapWithKeyEqualsEmptyString() {
        String input = "";
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put(input, 1);

        Cache cache = new Cache();
        Map<String, Integer> actual = counter.getResult(input, cache);

        assertEquals(expected, actual);
    }

    @Test
    public void givenOneSymbolString_whenCountElements_thenMapWithKeyEqualsSymbol() {
        String input = "a";
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put(input, 1);

        Cache cache = new Cache();
        Map<String, Integer> actual = counter.getResult(input, cache);

        assertEquals(expected, actual);
    }

    @Test
    public void givenFiveSymbolString_whenCountElements_thenMapWithFiveKey() {
        String input = "Hi Jo";
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("H", 1);
        expected.put("i", 1);
        expected.put(" ", 1);
        expected.put("J", 1);
        expected.put("o", 1);

        Cache cache = new Cache();
        Map<String, Integer> actual = counter.getResult(input, cache);

        assertEquals(expected, actual);
    }

    @Test
    public void givenStringWithSameSymbol_whenCountElements_thenMapWithKeyEqualsSymbol() {
        String input = "aaa";
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("a", 3);

        Cache cache = new Cache();
        Map<String, Integer> actual = counter.getResult(input, cache);

        assertEquals(expected, actual);
    }

    @Test
    public void givenStringWithNumbers_whenCountElements_thenMapWithKeysEqualsNumbers() {
        String input = "789";
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("7", 1);
        expected.put("8", 1);
        expected.put("9", 1);

        Cache cache = new Cache();
        Map<String, Integer> actual = counter.getResult(input, cache);

        assertEquals(expected, actual);
    }
}
