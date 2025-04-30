package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Index;
import javax.persistence.TableGenerator;
import java.util.List;

@Entity
@Table(name = "TempItems", indexes = {
    @Index(name = "idx_orderId", columnList = "orderId"),
    @Index(name = "idx_configId", columnList = "configId")
})
public class TempItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "orderId", nullable = true)
    private Long orderId;

    @Column(name = "configId")
    private Long configId;

    @ManyToOne
    @JoinColumn(name = "configId", insertable = false, updatable = false)
    private CustomConfig customConfig;

    public TempItem() {
    }

    public TempItem(Long orderId) {
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public CustomConfig getCustomConfig() {
        return customConfig;
    }

    public void setCustomConfig(CustomConfig customConfig) {
        this.customConfig = customConfig;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> getDisplayOptionsForSales() {
        try {
            String queryStr = "SELECT DISTINCT d FROM TempItem t " +
                              "JOIN CustomConfig c ON t.configId = c.id " +
                              "JOIN DisplayOptions d ON c.optionId = d.id";
            TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
            return query.getResultList();
        } catch (Exception e) {
            // Handle error (e.g., log the error)
            return null;
        }
    }

    public List<Object[]> getDisplayOptionsForMarketingData() {
        try {
            String queryStr = "SELECT DISTINCT d FROM TempItem t " +
                              "JOIN LegacyConfig l ON t.configId = l.id " +
                              "JOIN DisplayOptions d ON l.optionId = d.id";
            TypedQuery<Object[]> query = entityManager.createQuery(queryStr, Object[].class);
            return query.getResultList();
        } catch (Exception e) {
            // Handle error (e.g., log the error)
            return null;
        }
    }
}