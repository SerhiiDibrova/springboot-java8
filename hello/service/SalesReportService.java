package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class SalesReportService {

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void generateSalesReport(Long orderId, Long managerId, String xmlData, boolean auditFlag) {
        try {
            createTemporaryTable();
            populateTemporaryTable(orderId, managerId, xmlData);
            insertFinalReports(auditFlag);
        } catch (Exception e) {
            // Handle error appropriately
            throw new RuntimeException("Error generating sales report", e);
        }
    }

    private void createTemporaryTable() {
        Query query = entityManager.createNativeQuery("CREATE TABLE #SalesReport (id INT PRIMARY KEY, orderId BIGINT, managerId BIGINT, salesData XML)");
        query.executeUpdate();
    }

    private void populateTemporaryTable(Long orderId, Long managerId, String xmlData) {
        // XML parsing logic
        // Assume parseXmlData returns a list of sales data to be inserted
        List<SalesData> salesDataList = parseXmlData(xmlData);
        for (SalesData salesData : salesDataList) {
            Query query = entityManager.createNativeQuery("INSERT INTO #SalesReport (orderId, managerId, salesData) VALUES (:orderId, :managerId, :salesData)");
            query.setParameter("orderId", orderId);
            query.setParameter("managerId", managerId);
            query.setParameter("salesData", salesData);
            query.executeUpdate();
        }
    }

    private void insertFinalReports(boolean auditFlag) {
        Query query = entityManager.createNativeQuery("INSERT INTO SalesReports (orderId, managerId, salesData, auditFlag) SELECT orderId, managerId, salesData, :auditFlag FROM #SalesReport");
        query.setParameter("auditFlag", auditFlag);
        query.executeUpdate();
    }

    private List<SalesData> parseXmlData(String xmlData) {
        // Implement XML parsing logic here
        return null; // Replace with actual parsed data
    }

    public List<SalesReport> getSalesReports() {
        return salesReportRepository.findAll();
    }
}