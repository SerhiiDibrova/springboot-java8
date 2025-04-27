package hello.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TempItemsServiceTest {

    @InjectMocks
    private TempItemsService tempItemsService;

    @Mock
    private SomeDependency someDependency;

    private final String someValue = "someValue";
    private final String expectedValue = "expectedValue";

    public TempItemsServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveDisplayOptions() {
        when(someDependency.someMethod()).thenReturn(someValue);

        var result = tempItemsService.retrieveDisplayOptions();

        assertEquals(expectedValue, result);
        verify(someDependency).someMethod();
    }
}