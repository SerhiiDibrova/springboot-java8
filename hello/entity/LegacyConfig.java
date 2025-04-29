package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Index;

@Entity
@Table(name = "LegacyConfig", indexes = {@Index(name = "idx_module", columnList = "module")})
public class LegacyConfig {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "config_id")
    private String configId;

    @Column(name = "module")
    private String module;

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
}

package hello.service;

import hello.entity.LegacyConfig;
import hello.repository.LegacyConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegacyConfigService {

    @Autowired
    private LegacyConfigRepository legacyConfigRepository;

    public List<LegacyConfig> findByModule(String module) {
        if (module == null || !module.equals("MARKETING_DATA")) {
            throw new IllegalArgumentException("Invalid module type");
        }
        return legacyConfigRepository.findByModule(module);
    }
}

package hello.repository;

import hello.entity.LegacyConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LegacyConfigRepository extends JpaRepository<LegacyConfig, Long> {
    List<LegacyConfig> findByModule(String module);
}