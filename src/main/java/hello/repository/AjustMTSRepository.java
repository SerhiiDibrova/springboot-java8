package hello.repository;

import hello.entity.AjustMTSEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class AjustMTSRepository implements org.springframework.data.repository.CrudRepository<AjustMTSEntity, Long> {

    private final JdbcTemplate jdbcTemplate;
    private final NativeJdbcExtractor nativeJdbcExtractor;
    private final EntityManager entityManager;

    @Autowired
    public AjustMTSRepository(DataSource dataSource, NativeJdbcExtractor nativeJdbcExtractor, EntityManager entityManager) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.nativeJdbcExtractor = nativeJdbcExtractor;
        this.entityManager = entityManager;
    }

    @Transactional
    public <S extends AjustMTSEntity> S save(S entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    public <S extends AjustMTSEntity> Iterable<S> saveAll(Iterable<S> entities) {
        for (S entity : entities) {
            save(entity);
        }
        return entities;
    }

    public Optional<AjustMTSEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(AjustMTSEntity.class, id));
    }

    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Transactional
    public void deleteById(Long id) {
        AjustMTSEntity entity = findById(id).orElseThrow();
        delete(entity);
    }

    @Transactional
    public void delete(AjustMTSEntity entity) {
        entityManager.remove(entity);
    }

    @Transactional
    public void deleteAll(Iterable<? extends AjustMTSEntity> entities) {
        for (AjustMTSEntity entity : entities) {
            delete(entity);
        }
    }

    @Transactional
    public void deleteAll() {
        entityManager.createQuery("delete from AjustMTSEntity").executeUpdate();
    }

    public List<AjustMTSEntity> findAll() {
        return entityManager.createQuery("select a from AjustMTSEntity a", AjustMTSEntity.class).getResultList();
    }

    public long count() {
        return entityManager.createQuery("select count(a) from AjustMTSEntity a", Long.class).getSingleResult();
    }

    @Transactional
    public void executeTransaction(AjustMTSEntity ajustMTSEntity) {
        if (ajustMTSEntity == null) {
            throw new NullPointerException("AjustMTSEntity cannot be null");
        }
        if (ajustMTSEntity.getId() == null || ajustMTSEntity.getName() == null) {
            throw new IllegalArgumentException("AjustMTSEntity id and name cannot be null");
        }
        try {
            String query = "INSERT INTO ajust_mts (id, name) VALUES (?, ?)";
            jdbcTemplate.update(query, ajustMTSEntity.getId(), ajustMTSEntity.getName());
        } catch (Exception e) {
            throw new RuntimeException("Error executing transaction", e);
        }
    }
}