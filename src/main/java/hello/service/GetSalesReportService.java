package hello.service;

import hello.model.GetSalesReportRequestDTO;
import hello.repository.SalesReportRepository;
import hello.service.ManagerService;
import hello.service.SalesDataService;
import hello.service.WarehouseDataService;
import hello.entity.SalesReport;
import hello.entity.WarehouseData;
import hello.entity.SalesData;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.util.List;

@Service
class GetSalesReportService {
    private final SalesReportRepository salesReportRepository;
    private final ManagerService managerService;
    private final SalesDataService salesDataService;
    private final WarehouseDataService warehouseDataService;
    private static final Logger logger = LoggerFactory.getLogger(GetSalesReportService.class);

    public GetSalesReportService(SalesReportRepository salesReportRepository, ManagerService managerService, SalesDataService salesDataService, WarehouseDataService warehouseDataService) {
        this.salesReportRepository = salesReportRepository;
        this.managerService = managerService;
        this.salesDataService = salesDataService;
        this.warehouseDataService = warehouseDataService;
    }

    public void getSalesReport(GetSalesReportRequestDTO requestDTO) {
        if (requestDTO == null || requestDTO.getXmlData() == null) {
            logger.error("Invalid request DTO or XML data");
            return;
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDocument = builder.parse(requestDTO.getXmlData());
            Integer defaultManagerId = managerService.getDefaultManagerId(requestDTO.getManagerId());

            if (requestDTO.getIsAuditNeeded()) {
                // Implement audit data insertion logic here
            }

            List<SalesData> salesData = salesDataService.getSalesData(requestDTO.getOrderId(), xmlDocument);
            SalesReport salesReport = new SalesReport();
            salesReport.setSalesData(salesData);
            salesReportRepository.save(salesReport);

            List<WarehouseData> warehouseData = warehouseDataService.getWarehouseData(xmlDocument);
            WarehouseData warehouseReport = new WarehouseData();
            warehouseReport.setWarehouseData(warehouseData);
            warehouseDataService.save(warehouseReport);

        } catch (Exception e) {
            logger.error("Error generating sales report", e);
        }
    }
}