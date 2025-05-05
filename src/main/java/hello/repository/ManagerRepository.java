package hello.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<User, Integer> {
    
    Logger logger = LoggerFactory.getLogger(ManagerRepository.class);

    @Query(value = "SELECT TOP 1 u.id FROM users u INNER JOIN roles r ON u.role_id = r.id WHERE u.default = 1 AND r.role = 'system'", nativeQuery = true)
    Integer findDefaultManagerId() throws CustomNotFoundException;

    default Integer getDefaultManagerId() {
        try {
            Integer managerId = findDefaultManagerId();
            if (managerId == null) {
                throw new CustomNotFoundException("No default manager found.");
            }
            return managerId;
        } catch (DataAccessException e) {
            logger.error("Database connection issue: {}", e.getMessage());
            throw e;
        }
    }
}

class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String message) {
        super(message);
    }
}