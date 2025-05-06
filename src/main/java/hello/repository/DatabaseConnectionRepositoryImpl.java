package hello.repository;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hello.entity.DatabaseConnection;

@Repository
public class DatabaseConnectionRepositoryImpl {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConnectionRepositoryImpl.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    public List<Map<String, Object>> queryAll(String query, Object[] params) {
        LOGGER.fine("Executing query: " + query + " with params: " + java.util.Arrays.toString(params));
        try {
            Query nativeQuery = entityManager.createNativeQuery(query);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    nativeQuery.setParameter(i + 1, params[i]);
                }
            }
            List<Map<String, Object>> result = nativeQuery.getResultList();
            LOGGER.fine("Query executed successfully. Result size: " + result.size());
            return result;
        } catch (Exception e) {
            LOGGER.severe("Error executing query: " + e.getMessage());
            throw e;
        }
    }
}