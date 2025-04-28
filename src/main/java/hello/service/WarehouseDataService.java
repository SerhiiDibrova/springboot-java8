package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WarehouseDataService {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseDataService.class);

    @Autowired
    private WarehouseDataRepository warehouseDataRepository;

    public List<WarehouseData> getWarehouseData(List<TempItemDTO> tempItems) {
        try {
            List<ConvertedItem> convertedItems = tempItems.stream()
                .map(this::convertToSuitableFormat)
                .collect(Collectors.toList());
            return warehouseDataRepository.findByTempItems(convertedItems);
        } catch (Exception e) {
            logger.error("Error retrieving warehouse data", e);
            throw new RuntimeException("Failed to retrieve warehouse data", e);
        }
    }

    private ConvertedItem convertToSuitableFormat(TempItemDTO tempItem) {
        return new ConvertedItem(tempItem.getId(), tempItem.getName());
    }
}