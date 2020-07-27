package com.dudchenko;

import java.util.Map;

public abstract class CharsCounterDecorator implements CharsCounter {

    private CharsCounter counter;

    public CharsCounterDecorator(CharsCounter counter) {
        this.counter = counter;
    }

    @Override
    public Map<Character, Integer> countCharacters(String input) {
        return counter.countCharacters(input);
    }
}
