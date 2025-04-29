package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.LegacyConfig;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
    LegacyConfig findByOrderId(Long orderId);
    LegacyConfig findByConfigId(Long configId);
    
    @Override
    <S extends LegacyConfig> S save(S entity);
    
    @Override
    void deleteById(Long id);
    
    @Override
    void delete(LegacyConfig entity);
}