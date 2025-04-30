package hello.repository;

import hello.entity.DisplayOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisplayOptionsRepository extends PagingAndSortingRepository<DisplayOptions, Long> {
    
    @Query("SELECT d FROM DisplayOptions d WHERE d.configId = ?1")
    List<DisplayOptions> findByConfigId(Long configId);
    
    @Query("SELECT d FROM DisplayOptions d WHERE d.module = ?1")
    List<DisplayOptions> findByModule(String module);
    
    @Query("SELECT DISTINCT d FROM DisplayOptions d WHERE d.configId IN ?1")
    List<DisplayOptions> findDistinctByConfigIdIn(List<Long> configIds);
}