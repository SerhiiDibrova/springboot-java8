package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.DisplayOptions;

public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Long> {
    List<DisplayOptions> findBySomeField(String someField);
    Optional<DisplayOptions> findByIdAndAnotherField(Long id, String anotherField);
}