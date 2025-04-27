package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.WarehouseDataRepository;
import hello.dto.WarehouseDataDTO;
import hello.dto.TempItemsDTO;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseDataService {

    private final WarehouseDataRepository warehouseDataRepository;

    @Autowired
    public WarehouseDataService(WarehouseDataRepository warehouseDataRepository) {
        this.warehouseDataRepository = warehouseDataRepository;
    }

    public List<WarehouseDataDTO> getWarehouseData(List<TempItemsDTO> tempItems) {
        List<TempItems> items = tempItems.stream()
            .map(tempItem -> new TempItems(tempItem.getId(), tempItem.getName())) // Assuming TempItems has a constructor
            .collect(Collectors.toList());
        
        List<WarehouseData> warehouseDataList = warehouseDataRepository.findWarehouseDataByTempItems(items);
        
        return warehouseDataList.stream()
            .map(warehouseData -> new WarehouseDataDTO(warehouseData.getId(), warehouseData.getDescription())) // Assuming WarehouseDataDTO has a constructor
            .collect(Collectors.toList());
    }
}