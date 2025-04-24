

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Types;

@Repository
public interface WarehouseReportRepository extends JpaRepository<WarehouseReport, Long> {

    @PersistenceContext
    EntityManager entityManager();

    default JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(new DriverManagerDataSource());
    }

    default void createWarehouseReportTable() {
        jdbcTemplate().execute("CREATE TABLE warehouse_report (id INT, name VARCHAR(255))");
    }

    default WarehouseReport getWarehouseReport(Long id) {
        try {
            return entityManager().createQuery("SELECT wr FROM WarehouseReport wr WHERE wr.id = :id", WarehouseReport.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }
}