package hello.repository;

import hello.entity.LegacyFinancial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LegacyFinancialRepository extends JpaRepository<LegacyFinancial, Long> {
    List<LegacyFinancial> findAll();
    Optional<LegacyFinancial> findById(Long id);
    void deleteById(Long id);
    
    @Query("SELECT l FROM LegacyFinancial l WHERE l.someField = ?1")
    List<LegacyFinancial> findBySomeField(String someField);
    
    Page<LegacyFinancial> findAll(Pageable pageable);
}