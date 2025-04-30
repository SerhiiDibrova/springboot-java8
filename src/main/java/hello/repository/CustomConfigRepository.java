package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import hello.entity.CustomConfig;

@Repository
public interface CustomConfigRepository extends JpaRepository<CustomConfig, Integer> {
    List<CustomConfig> findByModule(String module);
}