package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "#audit_data")
public class AuditData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "audit_id", nullable = false)
    private Long auditId;

    @NotNull
    @Column(name = "record_details", nullable = false)
    private String recordDetails;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public String getRecordDetails() {
        return recordDetails;
    }

    public void setRecordDetails(String recordDetails) {
        this.recordDetails = recordDetails;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

package hello.repository;

import hello.entity.AuditData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditDataRepository extends JpaRepository<AuditData, Integer> {
}

package hello.service;

import hello.entity.AuditData;
import hello.repository.AuditDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditDataService {

    @Autowired
    private AuditDataRepository auditDataRepository;

    @Transactional
    public AuditData insertAuditData(Long auditId, String recordDetails) {
        AuditData auditData = new AuditData();
        auditData.setAuditId(auditId);
        auditData.setRecordDetails(recordDetails);
        auditData.setCreatedAt(LocalDateTime.now());
        return auditDataRepository.save(auditData);
    }
}

package hello.controller;

import hello.entity.AuditData;
import hello.service.AuditDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping
    public ResponseEntity<AuditData> createAuditData(@RequestParam Long auditId, @RequestParam String recordDetails) {
        AuditData auditData = auditDataService.insertAuditData(auditId, recordDetails);
        return ResponseEntity.ok(auditData);
    }
}