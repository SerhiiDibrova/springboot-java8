

package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.repository.TempItemRepository;
import com.example.repository.WarehouseReportRepository;
import com.example.repository.SalesReportRepository;

@Service
public class TemporaryTableService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private SalesReportRepository salesReportRepository;

    public void createTemporaryTables() {
        tempItemRepository.createTemporaryTable();
        warehouseReportRepository.createTemporaryTable();
        salesReportRepository.createTemporaryTable();
    }
}