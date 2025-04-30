package hello.entity;

import javax.persistence.*;
import java.util.List;
import javax.persistence.EntityManager;

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

    public List<DisplayOption> retrieveDisplayOptionsFromCustomConfig(EntityManager entityManager) {
        try {
            String query = "SELECT d FROM DisplayOption d JOIN CustomConfig c ON d.configId = c.id " +
                           "WHERE c.id = :configId " +
                           "UNION " +
                           "SELECT d FROM DisplayOption d JOIN LegacyConfig l ON d.configId = l.id " +
                           "WHERE l.id = :configId";
            return entityManager.createQuery(query, DisplayOption.class)
                                .setParameter("configId", this.configId)
                                .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving display options", e);
        }
    }
}