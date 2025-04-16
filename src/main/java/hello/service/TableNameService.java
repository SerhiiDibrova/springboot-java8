

package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TableNameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableNameService.class);

    @Autowired
    private EntityManager entityManager;

    public String getNameById(Integer id) {
        if (id == null) {
            LOGGER.error("Input id is null");
            return null;
        }

        Query query = entityManager.createQuery("SELECT name FROM TableName WHERE id = :id", String.class);
        query.setParameter("id", id);

        try {
            return (String) query.getSingleResult();
        } catch (NoResultException e) {
            LOGGER.error("No record found for id: {}", id);
            return null;
        } catch (Exception e) {
            LOGGER.error("Error retrieving name by id: {}", id, e);
            return null;
        }
    }
}