package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "#TempItems", indexes = {
    @Index(name = "idx_orderId", columnList = "orderId"),
    @Index(name = "idx_configId", columnList = "configId")
})
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "orderId", nullable = false)
    private Integer orderId;

    @Column(name = "configId", nullable = false)
    private Integer configId;

    @Column(name = "module")
    private String module;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> getDisplayOptionsFromCustomConfig() {
        try {
            String queryStr = "SELECT d.* FROM #TempItems t " +
                              "JOIN CustomConfig c ON t.configId = c.id " +
                              "JOIN DisplayOptions d ON c.displayOptionId = d.id " +
                              "UNION " +
                              "SELECT d.* FROM #TempItems t " +
                              "JOIN LegacyConfig l ON t.configId = l.id " +
                              "JOIN DisplayOptions d ON l.displayOptionId = d.id";
            Query query = entityManager.createNativeQuery(queryStr);
            return query.getResultList();
        } catch (Exception e) {
            // Handle error (e.g., log the error, rethrow as a custom exception, etc.)
            throw new RuntimeException("Error retrieving display options", e);
        }
    }

    public List<Object[]> getDisplayOptionsFromLegacyConfig() {
        try {
            String queryStr = "SELECT d.* FROM #TempItems t " +
                              "JOIN LegacyConfig l ON t.configId = l.id " +
                              "JOIN DisplayOptions d ON l.displayOptionId = d.id";
            Query query = entityManager.createNativeQuery(queryStr);
            return query.getResultList();
        } catch (Exception e) {
            // Handle error (e.g., log the error, rethrow as a custom exception, etc.)
            throw new RuntimeException("Error retrieving display options from LegacyConfig", e);
        }
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}