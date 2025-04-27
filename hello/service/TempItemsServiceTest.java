package hello.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import hello.model.TempItem;
import hello.repository.TempItemRepository;
import java.util.ArrayList;
import java.util.List;

class TempItemsServiceTest {

    @InjectMocks
    private TempItemsService tempItemsService;

    @Mock
    private TempItemRepository tempItemRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTempItems() {
        when(tempItemRepository.findAll()).thenReturn(new ArrayList<>());
        List<TempItem> items = tempItemsService.getAllTempItems();
        assertNotNull(items);
        assertTrue(items.isEmpty());
        verify(tempItemRepository, times(1)).findAll();
    }

    @Test
    void testAddTempItem() {
        TempItem item = new TempItem();
        when(tempItemRepository.save(item)).thenReturn(item);
        TempItem savedItem = tempItemsService.addTempItem(item);
        assertNotNull(savedItem);
        verify(tempItemRepository, times(1)).save(item);
    }

    @Test
    void testDeleteTempItem() {
        Long itemId = 1L;
        doNothing().when(tempItemRepository).deleteById(itemId);
        tempItemsService.deleteTempItem(itemId);
        verify(tempItemRepository, times(1)).deleteById(itemId);
    }

    @Test
    void testAddTempItemNull() {
        TempItem item = null;
        assertThrows(IllegalArgumentException.class, () -> {
            tempItemsService.addTempItem(item);
        });
    }

    @Test
    void testDeleteTempItemNotFound() {
        Long itemId = 999L;
        doThrow(new IllegalArgumentException("Item not found")).when(tempItemRepository).deleteById(itemId);
        assertThrows(IllegalArgumentException.class, () -> {
            tempItemsService.deleteTempItem(itemId);
        });
    }
}