package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesDataService {

    @Autowired
    private SalesDataRepository salesDataRepository;

    public List<SalesDataDTO> getSalesData(Integer orderId, List<TempItemDTO> tempItems) {
        if (orderId == null || tempItems == null || tempItems.isEmpty()) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        try {
            return salesDataRepository.fetchSalesData(orderId, tempItems);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving sales data", e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred", e);
        }
    }
}