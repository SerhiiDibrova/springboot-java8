package hello.service;

import hello.repository.DatabaseConnectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseConnectionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionService.class);

private final DatabaseConnectionRepository databaseConnectionRepository;
private final EntityManager entityManager;

@Autowired
public DatabaseConnectionService(DatabaseConnectionRepository databaseConnectionRepository, EntityManager entityManager) {
    this.databaseConnectionRepository = databaseConnectionRepository;
    this.entityManager = entityManager;
}

public List<Map<String, Object>> queryAll(String query, Object[] params) {
    LOGGER.debug("Executing query: {} with params: {}", query, params);
    Query nativeQuery = entityManager.createNativeQuery(query);
    for (int i = 0; i < params.length; i++) {
        nativeQuery.setParameter(i + 1, params[i]);
    }
    return nativeQuery.getResultList();
}