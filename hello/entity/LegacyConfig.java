package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.Optional;

@Entity
@Table(name = "legacy_config")
@NamedQueries({
    @NamedQuery(name = "LegacyConfig.findAll", query = "SELECT l FROM LegacyConfig l"),
    @NamedQuery(name = "LegacyConfig.findById", query = "SELECT l FROM LegacyConfig l WHERE l.orderId = :orderId")
})
public class LegacyConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "legacy_config_seq")
    @SequenceGenerator(name = "legacy_config_seq", sequenceName = "legacy_config_seq", allocationSize = 1)
    private Long orderId;

    @Column(name = "config_id")
    private String configId;

    @Column(name = "module")
    private String module;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "display_option_id")
    private DisplayOptions displayOptions;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public DisplayOptions getDisplayOptions() {
        return displayOptions;
    }

    public void setDisplayOptions(DisplayOptions displayOptions) {
        this.displayOptions = displayOptions;
    }
}

@PersistenceContext(type = PersistenceContextType.TRANSACTION)
@Transactional
public class LegacyConfigRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(LegacyConfig legacyConfig) {
        entityManager.persist(legacyConfig);
    }

    public Optional<LegacyConfig> findById(Long orderId) {
        return Optional.ofNullable(entityManager.createNamedQuery("LegacyConfig.findById", LegacyConfig.class)
                .setParameter("orderId", orderId)
                .getSingleResult());
    }

    public List<LegacyConfig> findAll() {
        return entityManager.createNamedQuery("LegacyConfig.findAll", LegacyConfig.class).getResultList();
    }

    public void delete(LegacyConfig legacyConfig) {
        entityManager.remove(entityManager.contains(legacyConfig) ? legacyConfig : entityManager.merge(legacyConfig));
    }
}