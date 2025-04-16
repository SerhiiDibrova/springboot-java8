

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hello.model.NameEntity;

@Repository
public interface NameRepository extends JpaRepository<NameEntity, Integer>, CrudRepository<NameEntity, Integer> {

    @Query(value = "SELECT n.name FROM NameEntity n WHERE n.id = ?1", nativeQuery = true)
    String getNameById(Integer id);
}

package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}