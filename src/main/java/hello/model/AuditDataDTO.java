package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AuditDataDTO {

    @NotNull
    @JsonProperty("id")
    private Integer id;

    @NotNull
    @Size(max = 255)
    @JsonProperty("details")
    private String details;

    @NotNull
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    public AuditDataDTO(@NotNull Integer id, @NotNull @Size(max = 255) String details, @NotNull LocalDateTime createdAt) {
        this.id = id;
        this.details = details;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}