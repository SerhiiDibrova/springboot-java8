package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.persistence.EntityListeners;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Entity
@Table(name = "SalesReport")
@EntityListeners(SalesReportListener.class)
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_Identifier")
    private Long orderIdentifier;

    @Column(name = "Customer_FullName")
    private String customerFullName;

    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "Sales_Status")
    private String salesStatus;

    public Long getOrderIdentifier() {
        return orderIdentifier;
    }

    public void setOrderIdentifier(Long orderIdentifier) {
        this.orderIdentifier = orderIdentifier;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }
}

@Repository
interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
    List<SalesReport> findBySalesStatus(String salesStatus);
}

@Service
@Transactional
class SalesReportService {

    @Autowired
    private SalesReportRepository salesReportRepository;

    public SalesReport save(SalesReport salesReport) {
        return salesReportRepository.save(salesReport);
    }

    public List<SalesReport> findAll() {
        return salesReportRepository.findAll();
    }

    public List<SalesReport> findBySalesStatus(String salesStatus) {
        return salesReportRepository.findBySalesStatus(salesStatus);
    }
}

@RestController
@RequestMapping("/sales-report")
class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping
    public SalesReport createSalesReport(@RequestBody SalesReport salesReport) {
        return salesReportService.save(salesReport);
    }

    @GetMapping
    public List<SalesReport> getAllSalesReports() {
        return salesReportService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<SalesReport> getSalesReportsByStatus(@PathVariable String status) {
        return salesReportService.findBySalesStatus(status);
    }
}

class SalesReportListener {

    @PrePersist
    public void prePersist(SalesReport salesReport) {
        // Add any pre-persist logic here
    }
}