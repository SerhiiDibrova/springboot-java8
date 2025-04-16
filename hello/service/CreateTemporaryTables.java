

package hello.service;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class CreateTemporaryTables {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createTemporaryTables() {
        entityManager.createNativeQuery("CREATE TEMPORARY TABLE temp_sales_report (id INT, product_name VARCHAR(255), quantity INT, total_price DECIMAL(10, 2))").executeUpdate();
        entityManager.createNativeQuery("CREATE TEMPORARY TABLE temp_sales_report_details (id INT, sales_report_id INT, product_id INT, quantity INT, unit_price DECIMAL(10, 2))").executeUpdate();
        entityManager.createNativeQuery("CREATE TEMPORARY TABLE temp_products (id INT, name VARCHAR(255), price DECIMAL(10, 2))").executeUpdate();
    }
}