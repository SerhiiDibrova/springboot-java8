package hello.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.SalesReportModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class SalesReportRepositoryImpl implements SalesReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createTemporaryTable() {
        entityManager.createNativeQuery("CREATE TEMPORARY TABLE temp_sales_report AS SELECT * FROM sales_report WHERE 1=0").executeUpdate();
    }

    @Override
    @Transactional
    public void insertDataIntoTemporaryTable(SalesReportModel salesReport) {
        entityManager.persist(salesReport);
    }
}