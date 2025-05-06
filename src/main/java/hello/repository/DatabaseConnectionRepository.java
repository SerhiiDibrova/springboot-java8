package hello.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class DatabaseConnectionRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

    public List<Map<String, Object>> queryAll(String query, Object[] params) {
        LOGGER.debug("Executing query: {} with params: {}", query, params);

        Query nativeQuery = entityManager.createNativeQuery(query);
        for (int i = 0; i < params.length; i++) {
            nativeQuery.setParameter(i + 1, params[i]);
        }

        List<Map<String, Object>> result = nativeQuery.getResultList();
        return result;
    }
}