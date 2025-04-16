

package hello.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

public interface NameRetrievalRepository extends JpaRepository<NameEntity, Integer> {

    @Query("SELECT n.name FROM NameEntity n WHERE n.id = :id")
    String retrieveNameById(@Param("id") Integer id);
}

@Entity
class NameEntity {
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

@Service
class NameRetrievalServiceImpl implements NameRetrievalService {

    private final NameRetrievalRepository nameRetrievalRepository;

    public NameRetrievalServiceImpl(NameRetrievalRepository nameRetrievalRepository) {
        this.nameRetrievalRepository = nameRetrievalRepository;
    }

    @Override
    public String retrieveNameById(Integer id) {
        return nameRetrievalRepository.retrieveNameById(id);
    }
}