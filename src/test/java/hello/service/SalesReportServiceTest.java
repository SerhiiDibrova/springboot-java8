package hello.service;

import hello.repository.SalesReportRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;

public class SalesReportServiceTest {

    @InjectMocks
    private SalesReportService salesReportService;

    @Mock
    private SalesReportRepository salesReportRepository;

    public SalesReportServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertSalesReport() {
        SalesReport salesReport = new SalesReport();

        salesReportService.insertSalesReport(salesReport);

        verify(salesReportRepository).save(salesReport);
    }

    @Test
    public void testInsertSalesReport_NullInput() {
        salesReportService.insertSalesReport(null);

        verify(salesReportRepository).save(null);
    }

    @Test
    public void testInsertSalesReport_InvalidData() {
        SalesReport salesReport = new SalesReport();
        salesReport.setInvalidData(true);

        salesReportService.insertSalesReport(salesReport);

        verify(salesReportRepository).save(salesReport);
    }

    @Test
    public void testInsertSalesReport_ExceptionHandling() {
        SalesReport salesReport = new SalesReport();
        doThrow(new RuntimeException()).when(salesReportRepository).save(salesReport);

        try {
            salesReportService.insertSalesReport(salesReport);
        } catch (RuntimeException e) {
            // Expected exception
        }

        verify(salesReportRepository).save(salesReport);
    }

    @Test
    public void testInsertSalesReport_NoInteractionOnNull() {
        salesReportService.insertSalesReport(null);

        verify(salesReportRepository).save(null);
    }
}