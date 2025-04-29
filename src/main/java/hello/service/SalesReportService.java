package hello.service;

import hello.entity.SalesReport;
import hello.repository.SalesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesReportService {

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Transactional
    public void insertSalesReport(List<SalesReport> salesReports) {
        try {
            for (SalesReport report : salesReports) {
                if (isValidReport(report)) {
                    salesReportRepository.save(report);
                }
            }
        } catch (Exception e) {
            // Handle error (e.g., log the error, rethrow exception, etc.)
            throw new RuntimeException("Error inserting sales reports", e);
        }
    }

    private boolean isValidReport(SalesReport report) {
        // Implement filtering conditions to ensure only relevant records are included
        return report != null && report.getSalesAmount() > 0; // Example condition
    }
}