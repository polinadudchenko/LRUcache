package com.dudchenko;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachedCharsCounterTest {

    @InjectMocks
    private CachedCharsCounter cachedCharsCounter;
    @Mock
    private CharsCounter charsCounter;

    @Test
    public void givenStringTwoTimes_whenCountCharacters_thenCharsCounterCountCharactersExecutedOneTime() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('h', 1);
        map.put('i', 1);
        when(charsCounter.countCharacters("hi")).thenReturn(map);

        cachedCharsCounter.countCharacters("hi");
        cachedCharsCounter.countCharacters("hi");

        verify(charsCounter).countCharacters("hi");
    }
}
