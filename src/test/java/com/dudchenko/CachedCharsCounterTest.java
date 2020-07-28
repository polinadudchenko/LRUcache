package com.dudchenko;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CachedCharsCounterTest {

    @InjectMocks
    private CachedCharsCounter сachedCharsCounter;
    @Mock
    private CharsCounter charsCounter;

    @Test
    public void givenParametersToPut_whenCountCharacters_thenCountCharactersExecuted() {
        CachedCharsCounter spyCache = Mockito.spy(сachedCharsCounter);
        spyCache.countCharacters("hi");
        spyCache.countCharacters("hi");

        Mockito.verify(spyCache, Mockito.times(2)).countCharacters("hi");
        Mockito.verify(charsCounter, Mockito.times(1)).countCharacters("hi");
    }
}
