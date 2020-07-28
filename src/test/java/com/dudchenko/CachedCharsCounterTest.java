package com.dudchenko;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyMap;

@ExtendWith(MockitoExtension.class)
class CachedCharsCounterTest {

    private CachedCharsCounter cachedCharsCounter;
    @Mock
    private CharsCounter charsCounter;

    @Test
    public void givenParametersToPut_whenCountCharacters_thenCountCharactersExecuted() {
        cachedCharsCounter = new CachedCharsCounter(charsCounter);

        Mockito.when(charsCounter.countCharacters("hi")).thenReturn(anyMap());

        cachedCharsCounter.countCharacters("hi");
        cachedCharsCounter.countCharacters("hi");

        Mockito.verify(charsCounter).countCharacters("hi");
    }
}
