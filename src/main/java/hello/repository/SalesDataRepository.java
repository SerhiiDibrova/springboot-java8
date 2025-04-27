package hello.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface SalesDataRepository extends JpaRepository<SalesData, Long> {
    List<SalesData> findAll();
    SalesData findById(Long id);
    void save(SalesData salesData);
    void deleteById(Long id);
}