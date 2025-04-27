package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.model.WarehouseData;
import hello.model.TempItems;
import java.util.List;

@Service
public class WarehouseDataService {

    private final WarehouseDataRepository warehouseDataRepository;

    @Autowired
    public WarehouseDataService(WarehouseDataRepository warehouseDataRepository) {
        this.warehouseDataRepository = warehouseDataRepository;
    }

    public List<WarehouseData> getWarehouseData(List<TempItems> tempItems) {
        try {
            return warehouseDataRepository.findWarehouseDataByTempItems(tempItems);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving warehouse data: " + e.getMessage(), e);
        }
    }
}