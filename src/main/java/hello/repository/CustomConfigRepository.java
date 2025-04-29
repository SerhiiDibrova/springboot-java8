package hello.repository;

import hello.entity.CustomConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomConfigRepository extends JpaRepository<CustomConfig, Long> {
    
    @Query("SELECT c FROM CustomConfig c WHERE c.module = :module")
    List<CustomConfig> findByModule(@Param("module") String module);
    
    @Query("SELECT c FROM CustomConfig c WHERE c.module = 'SALES'")
    List<CustomConfig> findSalesConfig();
}