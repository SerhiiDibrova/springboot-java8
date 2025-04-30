package hello.entity;

import javax.persistence.*;
import java.util.List;
import javax.persistence.criteria.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "#TempItems")
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer orderId;

    @Column(nullable = false)
    private Integer configId;

    @Column
    private String module;

    @PersistenceContext
    private EntityManager entityManager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<DisplayOption> retrieveDisplayOptionsFromCustomConfig() {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<DisplayOption> query = cb.createQuery(DisplayOption.class);
            Root<TempItem> tempItem = query.from(TempItem.class);
            Join<TempItem, CustomConfig> customConfig = tempItem.join("customConfig");
            Join<CustomConfig, DisplayOption> displayOption = customConfig.join("displayOptions");

            query.select(displayOption).where(cb.equal(tempItem.get("module"), this.module));

            TypedQuery<DisplayOption> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            // Handle error
            return null;
        }
    }

    public List<DisplayOption> retrieveDisplayOptionsFromLegacyConfig() {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<DisplayOption> query = cb.createQuery(DisplayOption.class);
            Root<TempItem> tempItem = query.from(TempItem.class);
            Join<TempItem, LegacyConfig> legacyConfig = tempItem.join("legacyConfig");
            Join<LegacyConfig, DisplayOption> displayOption = legacyConfig.join("displayOptions");

            query.select(displayOption).where(cb.equal(tempItem.get("module"), this.module));

            TypedQuery<DisplayOption> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            // Handle error
            return null;
        }
    }
}