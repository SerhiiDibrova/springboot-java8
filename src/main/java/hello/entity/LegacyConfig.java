package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.List;

@Entity
@Table(name = "TempItems")
public class TempItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private Long orderId;

    @Column(nullable = true)
    private Long configId;

    @PersistenceContext
    private EntityManager entityManager;

    public TempItem() {
    }

    public TempItem(Long orderId, Long configId) {
        this.orderId = orderId;
        this.configId = configId;
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

    public List<String> retrieveDisplayOptions() {
        try {
            String jpql = "SELECT DISTINCT d.option FROM DisplayOptions d " +
                          "JOIN CustomConfig c ON d.configId = c.id " +
                          "JOIN LegacyConfig l ON d.configId = l.id " +
                          "WHERE c.id = :configId OR l.id = :configId";
            TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
            query.setParameter("configId", this.configId);
            return query.getResultList();
        } catch (NoResultException e) {
            return List.of();
        } catch (PersistenceException e) {
            // Handle persistence exceptions
            return List.of();
        }
    }
}