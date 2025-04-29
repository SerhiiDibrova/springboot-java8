package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.repository.SalesReportRepository;
import hello.model.SalesReport;

import java.util.List;

@Service
public class SalesReportService {

    private final SalesReportRepository salesReportRepository;
    private static final Logger logger = LoggerFactory.getLogger(SalesReportService.class);

    @Autowired
    public SalesReportService(SalesReportRepository salesReportRepository) {
        this.salesReportRepository = salesReportRepository;
    }

    public List<SalesReport> generateSalesReport() {
        logger.info("Generating sales report");
        return salesReportRepository.findAll();
    }

    public SalesReport getSalesReportById(Long id) {
        logger.info("Retrieving sales report with id: {}", id);
        return salesReportRepository.findById(id).orElse(null);
    }

    public SalesReport createSalesReport(SalesReport salesReport) {
        validateSalesReport(salesReport);
        logger.info("Creating sales report: {}", salesReport);
        return salesReportRepository.save(salesReport);
    }

    public SalesReport updateSalesReport(Long id, SalesReport salesReport) {
        validateSalesReport(salesReport);
        if (salesReportRepository.existsById(id)) {
            salesReport.setId(id);
            logger.info("Updating sales report with id: {}", id);
            return salesReportRepository.save(salesReport);
        }
        logger.warn("Sales report with id: {} not found for update", id);
        return null;
    }

    public void deleteSalesReport(Long id) {
        if (salesReportRepository.existsById(id)) {
            logger.info("Deleting sales report with id: {}", id);
            salesReportRepository.deleteById(id);
        } else {
            logger.warn("Sales report with id: {} not found for deletion", id);
        }
    }

    public List<SalesReport> getSalesReportsByCriteria(String criteria) {
        logger.info("Retrieving sales reports by criteria: {}", criteria);
        return salesReportRepository.findByCriteria(criteria);
    }

    private void validateSalesReport(SalesReport salesReport) {
        if (salesReport == null || salesReport.getField() == null) {
            throw new IllegalArgumentException("Sales report is invalid");
        }
    }
}