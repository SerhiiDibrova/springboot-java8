package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesDataService {
    @Autowired
    private SalesDataRepository salesDataRepository;

    public List<SalesData> getSalesData(Integer orderId, List<TempItemDTO> tempItems) {
        List<ConvertedTempItem> convertedTempItems = convertTempItems(tempItems);
        return salesDataRepository.findSalesDataByOrderIdAndTempItems(orderId, convertedTempItems);
    }

    private List<ConvertedTempItem> convertTempItems(List<TempItemDTO> tempItems) {
        return tempItems.stream()
                .map(tempItem -> new ConvertedTempItem(tempItem.getId(), tempItem.getQuantity()))
                .collect(Collectors.toList());
    }
}