

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import hello.entity.TriggerEntity;

import javax.persistence.QueryHint;
import java.util.Optional;

@Repository
public interface TriggerRepository extends JpaRepository<TriggerEntity, Long> {

    @Query("SELECT t FROM TriggerEntity t WHERE t.id = :id ORDER BY t.id DESC")
    @QueryHints({@QueryHint(name = org.hibernate.annotations.QueryHints.FETCH_SIZE, value = "1")})
    Optional<TriggerEntity> findTopById(@Param("id") Long id);
}