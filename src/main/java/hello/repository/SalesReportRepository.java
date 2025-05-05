package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class SalesReportRepositoryImpl implements SalesReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createTempTable(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void executeInsertSalesReport(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }
}