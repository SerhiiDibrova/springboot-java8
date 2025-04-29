package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WarehouseReportService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private LegacyLogisticsRepository legacyLogisticsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LegacyFinancialsRepository legacyFinancialsRepository;

    @Transactional
    public void insertWarehouseReport() {
        List<TempItem> tempItems = tempItemRepository.findAll();
        for (TempItem tempItem : tempItems) {
            if (isValidTempItem(tempItem)) {
                WarehouseReport report = constructWarehouseReport(tempItem);
                warehouseReportRepository.save(report);
            }
        }
    }

    private boolean isValidTempItem(TempItem tempItem) {
        return tempItem.getField1() != null && tempItem.getField2() != null;
    }

    private WarehouseReport constructWarehouseReport(TempItem tempItem) {
        WarehouseReport report = new WarehouseReport();
        List<Order> orders = orderRepository.findByTempItemId(tempItem.getId());
        List<Inventory> inventories = inventoryRepository.findByTempItemId(tempItem.getId());
        List<Warehouse> warehouses = warehouseRepository.findByTempItemId(tempItem.getId());
        List<Product> products = productRepository.findByTempItemId(tempItem.getId());
        List<Vendor> vendors = vendorRepository.findByTempItemId(tempItem.getId());
        List<Branch> branches = branchRepository.findByTempItemId(tempItem.getId());
        List<Region> regions = regionRepository.findByTempItemId(tempItem.getId());
        List<LegacyLogistics> legacyLogistics = legacyLogisticsRepository.findByTempItemId(tempItem.getId());
        List<Employee> employees = employeeRepository.findByTempItemId(tempItem.getId());
        List<LegacyFinancials> legacyFinancials = legacyFinancialsRepository.findByTempItemId(tempItem.getId());

        // Populate report fields based on the retrieved data
        report.setField1(tempItem.getField1());
        report.setField2(tempItem.getField2());
        // Additional field mappings based on joins

        return report;
    }
}