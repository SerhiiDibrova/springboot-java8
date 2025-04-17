

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.entity.NameEntity;

@Repository
public interface NameRepository extends JpaRepository<NameEntity, Integer> {

    NameEntity findByNameId(Integer id);

    NameEntity save(NameEntity nameEntity);

}