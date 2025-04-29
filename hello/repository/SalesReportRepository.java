package hello.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.model.SalesReport;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class SalesReportRepository {

    @Autowired
    private JpaRepository<SalesReport, Long> jpaRepository;

    public SalesReport findById(Long id) {
        return jpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("SalesReport not found"));
    }

    public List<SalesReport> findAll() {
        return jpaRepository.findAll();
    }

    public SalesReport save(SalesReport salesReport) {
        return jpaRepository.save(salesReport);
    }

    public void deleteById(Long id) {
        if (!jpaRepository.existsById(id)) {
            throw new EntityNotFoundException("SalesReport not found");
        }
        jpaRepository.deleteById(id);
    }
}