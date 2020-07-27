package com.dudchenko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CachedCharsCounterTest {

    @InjectMocks
    private CachedCharsCounter cache;
    @Mock
    private UniqueCharsCounter counter;

    @BeforeEach
    private void setUp() {
        counter = new UniqueCharsCounter();
        cache = new CachedCharsCounter(counter);
    }

    @Test
    public void givenParametersToPut_whenPut_thenPutExecuted() {
        CachedCharsCounter spyCache = Mockito.spy(cache);
        spyCache.countCharacters("hi");

        Mockito.verify(spyCache).countCharacters("hi");
    }
}
