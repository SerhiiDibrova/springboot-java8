

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.entity.Proc32Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Repository
public interface Proc32Repository extends JpaRepository<Proc32Entity, Long> {

    @Query("SELECT p FROM Proc32Entity p WHERE p.id = :id")
    Proc32Entity findById(@NotNull @Param("id") Long id);

    default Proc32Entity save(@NotNull @Valid Proc32Entity proc32Entity) {
        return save(proc32Entity);
    }
}