

package hello.service;

import java.util.List;
import java.util.logging.Logger;
import hello.model.SalesData;
import hello.repository.SalesReportRepository;
import org.springframework.stereotype.Service;

@Service
public class GetSalesDataService {

    private static final Logger LOGGER = Logger.getLogger(GetSalesDataService.class.getName());

    private SalesReportRepository salesReportRepository;

    public GetSalesDataService(SalesReportRepository salesReportRepository) {
        this.salesReportRepository = salesReportRepository;
    }

    public List<SalesData> getSalesData(String customerName, Double salesAmount, Double discountRate) {
        if (customerName == null || customerName.isEmpty() || salesAmount == null || discountRate == null) {
            LOGGER.severe("Invalid input parameters");
            throw new IllegalArgumentException("Invalid input parameters");
        }

        try {
            List<SalesData> salesDataList = salesReportRepository.getSalesData();
            return salesDataList.stream()
                    .filter(salesData -> salesData.getOrderStatus().equals("Completed"))
                    .filter(salesData -> salesData.getCustomerName().contains(customerName))
                    .filter(salesData -> salesData.getSalesAmount() > salesAmount)
                    .filter(salesData -> salesData.getDiscountRate() < discountRate)
                    .map(salesData -> {
                        salesData.setOrderIdentifier(salesData.getOrderId() + "-" + salesData.getOrderStatus());
                        salesData.setCustomerFullName(salesData.getCustomerName() + " " + salesData.getCustomerLastName());
                        return salesData;
                    })
                    .toList();
        } catch (Exception e) {
            LOGGER.severe("Error retrieving sales data: " + e.getMessage());
            throw new RuntimeException("Error retrieving sales data", e);
        }
    }
}