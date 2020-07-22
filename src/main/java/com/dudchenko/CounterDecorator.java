package com.dudchenko;

import java.util.Map;

public abstract class CounterDecorator implements ICounter{

    private ICounter counter;

    public CounterDecorator(ICounter counter) {
        this.counter = counter;
    }

    @Override
    public Map<Character, Integer> countCharacters(String input) {
        return counter.countCharacters(input);
    }
}
