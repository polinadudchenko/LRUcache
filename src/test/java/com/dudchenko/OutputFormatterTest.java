package com.dudchenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OutputFormatterTest {

    private OutputFormatter formatter;

    @BeforeEach
    private void setUp() {
        formatter = new OutputFormatter();
    }

    @Test
    public void givenOneSizeMap_whenFormat_thenOneStringResult() {
        StringBuilder expected = new StringBuilder();
        expected.append("\"I\"").append(" ").append("-").append(" ").append(1).append(System.lineSeparator());
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("I", 1);
        String actual = formatter.format(map);
        assertEquals(expected.toString(), actual);
    }

    @Test
    public void givenMapWithTwoKeys_whenFormat_thenTwoStringsResult(){
        StringBuilder expected = new StringBuilder();
        expected.append("\"h\"").append(" ").append("-").append(" ").append(1).append(System.lineSeparator());
        expected.append("\"i\"").append(" ").append("-").append(" ").append(1).append(System.lineSeparator());
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("h", 1);
        map.put("i", 1);
        String actual = formatter.format(map);
        assertEquals(expected.toString(), actual);
    }

    @Test
    public void givenMapWithFourKeys_whenFormat_thenFourStringsResult(){
        StringBuilder expected = new StringBuilder();
        expected.append("\"h\"").append(" ").append("-").append(" ").append(1).append(System.lineSeparator());
        expected.append("\"e\"").append(" ").append("-").append(" ").append(1).append(System.lineSeparator());
        expected.append("\"l\"").append(" ").append("-").append(" ").append(2).append(System.lineSeparator());
        expected.append("\"o\"").append(" ").append("-").append(" ").append(1).append(System.lineSeparator());
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("h", 1);
        map.put("e", 1);
        map.put("l", 2);
        map.put("o", 1);
        String actual = formatter.format(map);
        assertEquals(expected.toString(), actual);
    }

}
