package hello.repository;

import hello.entity.DisplayOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Long> {

    @Query("SELECT DISTINCT d FROM DisplayOptions d " +
           "JOIN CustomConfig c ON d.id = c.displayOptionId " +
           "WHERE c.moduleType IN ('SALES', 'MARKETING_DATA')")
    List<DisplayOptions> findByCustomConfigModuleTypes();

    @Query("SELECT DISTINCT d FROM DisplayOptions d " +
           "JOIN LegacyConfig l ON d.id = l.displayOptionId " +
           "WHERE l.moduleType IN ('SALES', 'MARKETING_DATA')")
    List<DisplayOptions> findByLegacyConfigModuleTypes();
}