

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.entity.TempItem;

@Repository
public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    void createTempItemsTable();
}

package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class TempItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "hello.repository")
public class JpaConfig {
}

package hello.repository.impl;

import hello.repository.TempItemRepository;
import hello.entity.TempItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TempItemRepositoryImpl implements TempItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createTempItemsTable() {
        entityManager.createNativeQuery("CREATE TABLE #TempItems (id BIGINT PRIMARY KEY, name VARCHAR(255), description VARCHAR(255))").executeUpdate();
    }

    @Override
    public List<TempItem> findAll() {
        return entityManager.createQuery("SELECT t FROM TempItem t").getResultList();
    }

    @Override
    public TempItem findById(Long id) {
        return entityManager.find(TempItem.class, id);
    }

    @Override
    public TempItem save(TempItem tempItem) {
        return entityManager.merge(tempItem);
    }

    @Override
    public void delete(TempItem tempItem) {
        entityManager.remove(tempItem);
    }

    @Override
    public void deleteById(Long id) {
        TempItem tempItem = findById(id);
        if (tempItem != null) {
            delete(tempItem);
        }
    }
}