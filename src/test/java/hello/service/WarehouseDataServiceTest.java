package hello.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import hello.service.WarehouseDataService;
import hello.repository.WarehouseDataRepository;
import hello.dto.TempItemsDTO;
import hello.dto.WarehouseDataDTO;
import java.util.List;

@SpringBootTest
public class WarehouseDataServiceTest {

    @InjectMocks
    private WarehouseDataService warehouseDataService;

    @Mock
    private WarehouseDataRepository warehouseDataRepository;

    public WarehouseDataServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWarehouseData_ValidInput() {
        TempItemsDTO tempItemsDTO = new TempItemsDTO();
        // Set properties of tempItemsDTO as needed

        WarehouseDataDTO expectedData = new WarehouseDataDTO();
        // Set expected properties of expectedData

        when(warehouseDataRepository.findData(tempItemsDTO)).thenReturn(expectedData);

        WarehouseDataDTO actualData = warehouseDataService.getWarehouseData(tempItemsDTO);

        assertEquals(expectedData, actualData);
        verify(warehouseDataRepository, times(1)).findData(tempItemsDTO);
    }

    @Test
    public void testGetWarehouseData_EmptyInput() {
        TempItemsDTO tempItemsDTO = new TempItemsDTO();
        // Set properties of tempItemsDTO to represent empty input

        when(warehouseDataRepository.findData(tempItemsDTO)).thenReturn(null);

        WarehouseDataDTO actualData = warehouseDataService.getWarehouseData(tempItemsDTO);

        assertNull(actualData);
        verify(warehouseDataRepository, times(1)).findData(tempItemsDTO);
    }

    @Test
    public void testGetWarehouseData_NullInput() {
        WarehouseDataDTO actualData = warehouseDataService.getWarehouseData(null);

        assertNull(actualData);
        verify(warehouseDataRepository, never()).findData(any());
    }

    @Test
    public void testGetWarehouseData_MultipleItems() {
        TempItemsDTO tempItemsDTO = new TempItemsDTO();
        // Set properties of tempItemsDTO for multiple items

        List<WarehouseDataDTO> expectedDataList = List.of(new WarehouseDataDTO(), new WarehouseDataDTO());
        when(warehouseDataRepository.findData(tempItemsDTO)).thenReturn(expectedDataList);

        List<WarehouseDataDTO> actualDataList = warehouseDataService.getWarehouseData(tempItemsDTO);

        assertEquals(expectedDataList, actualDataList);
        verify(warehouseDataRepository, times(1)).findData(tempItemsDTO);
    }
}