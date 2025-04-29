package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.entity.DisplayOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

@Repository
public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Long> {
    Logger logger = LoggerFactory.getLogger(DisplayOptionsRepository.class);

    default void safeDeleteById(Long id) {
        try {
            deleteById(id);
        } catch (DataAccessException e) {
            logger.error("Error deleting DisplayOptions with id: " + id, e);
        }
    }

    default DisplayOptions safeFindById(Long id) {
        try {
            return findById(id).orElse(null);
        } catch (DataAccessException e) {
            logger.error("Error finding DisplayOptions with id: " + id, e);
            return null;
        }
    }
}