package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

public class AuditDataDTO implements Serializable {
    @NotNull
    @JsonProperty("auditId")
    private int auditId;

    @Size(max = 500)
    @JsonProperty("recordDetails")
    private String recordDetails;

    @NotNull
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    public AuditDataDTO(@NotNull int auditId, @Size(max = 500) String recordDetails, @NotNull LocalDateTime createdAt) {
        this.auditId = auditId;
        this.recordDetails = recordDetails;
        this.createdAt = createdAt;
    }

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
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