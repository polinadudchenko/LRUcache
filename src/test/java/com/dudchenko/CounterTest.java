package com.dudchenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    private UniqueCharsCounter counter;

    @BeforeEach
    private void setUp() {
        counter = new UniqueCharsCounter();
    }

    @Test
    public void givenThreeSpaceString_whenCountElements_thenMapWithKeyEqualsSpace() {
        String input = "   ";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put
                (input.charAt(0), 3);

        Map<Character, Integer> actual = counter.countCharacters(input);

        assertEquals(expected, actual);
    }

    @Test
    public void givenOneSymbolString_whenCountElements_thenMapWithKeyEqualsSymbol() {
        String input = "a";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put(input.charAt(0), 1);

        Map<Character, Integer> actual = counter.countCharacters(input);

        assertEquals(expected, actual);
    }

    @Test
    public void givenFiveSymbolString_whenCountElements_thenMapWithFiveKey() {
        String input = "Hi Jo";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('H', 1);
        expected.put('i', 1);
        expected.put(' ', 1);
        expected.put('J', 1);
        expected.put('o', 1);

        Map<Character, Integer> actual = counter.countCharacters(input);

        assertEquals(expected, actual);
    }

    @Test
    public void givenStringWithSameSymbol_whenCountElements_thenMapWithKeyEqualsSymbol() {
        String input = "aaa";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 3);

        Map<Character, Integer> actual = counter.countCharacters(input);

        assertEquals(expected, actual);
    }

    @Test
    public void givenStringWithNumbers_whenCountElements_thenMapWithKeysEqualsNumbers() {
        String input = "789";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('7', 1);
        expected.put('8', 1);
        expected.put('9', 1);

        Map<Character, Integer> actual = counter.countCharacters(input);

        assertEquals(expected, actual);
    }
}
