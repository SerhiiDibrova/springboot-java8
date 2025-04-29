package hello.entity;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "TempItems")
public class TempItem {

    @Id
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "config_id", nullable = false)
    private Integer configId;

    // Additional fields can be added here

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

    @PersistenceContext
    private EntityManager entityManager;

    public List<DisplayOption> getSalesDisplayOptions() {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<DisplayOption> cq = cb.createQuery(DisplayOption.class);
            Root<DisplayOption> displayOption = cq.from(DisplayOption.class);
            Join<DisplayOption, CustomConfig> customConfig = displayOption.join("customConfig");
            cq.select(displayOption).where(cb.equal(customConfig.get("orderId"), this.orderId));
            TypedQuery<DisplayOption> query = entityManager.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            // Handle error
            return null;
        }
    }

    public List<DisplayOption> getMarketingDataDisplayOptions() {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<DisplayOption> cq = cb.createQuery(DisplayOption.class);
            Root<DisplayOption> displayOption = cq.from(DisplayOption.class);
            Join<DisplayOption, LegacyConfig> legacyConfig = displayOption.join("legacyConfig");
            cq.select(displayOption).where(cb.equal(legacyConfig.get("orderId"), this.orderId));
            TypedQuery<DisplayOption> query = entityManager.createQuery(cq);
            return query.getResultList();
        } catch (Exception e) {
            // Handle error
            return null;
        }
    }
}