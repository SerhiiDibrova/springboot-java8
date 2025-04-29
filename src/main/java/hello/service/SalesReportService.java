package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.repository.SalesReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SalesReportService {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportService.class);

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Transactional
    public void insertSalesReport(String filterCriteria) {
        try {
            salesReportRepository.createTemporaryTable();
            salesReportRepository.executeSalesReportProcedure(filterCriteria);
        } catch (Exception e) {
            logger.error("Error inserting sales report", e);
            throw e;
        }
    }
}