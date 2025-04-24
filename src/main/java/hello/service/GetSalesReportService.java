

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.dto.SalesReportDTO;
import hello.repository.SalesReportRepository;

@Service
public class GetSalesReportService {

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Transactional
    public SalesReportDTO getSalesReport() {
        SalesReportDTO salesReportDTO = new SalesReportDTO();
        salesReportDTO.setSalesReportData(salesReportRepository.getSalesReportData());
        return salesReportDTO;
    }
}