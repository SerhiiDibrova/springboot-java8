package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuditData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(nullable = false)
    private String auditId;
    
    @Column(length = 255, nullable = false)
    private String recordDetails;
    
    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public void insertAuditData(String auditId, String recordDetails, LocalDateTime createdAt) {
        // Implementation for inserting data into the audit_data table
    }
}