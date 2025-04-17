

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import hello.dto.WarehouseReportDTO;
import hello.repository.WarehouseReportRepository;

@Service
public class WarehouseReportService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private WarehouseReportRepository warehouseReportRepository;

    @Transactional
    public List<WarehouseReportDTO> generateWarehouseReport() {
        Query query = entityManager.createQuery("SELECT new hello.dto.WarehouseReportDTO(s.product, SUM(s.quantity)) "
                + "FROM Sales s GROUP BY s.product");
        List<WarehouseReportDTO> reports = query.getResultList();
        return reports;
    }
}