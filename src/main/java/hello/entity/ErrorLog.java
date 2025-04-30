package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "error_logs")
public class ErrorLog {

    @NotNull
    @Column(name = "error_message", columnDefinition = "NVARCHAR(MAX)", nullable = false)
    private String errorMessage;

    @NotNull
    @Column(name = "error_severity", nullable = false)
    private Integer errorSeverity;

    @NotNull
    @Column(name = "error_state", nullable = false)
    private Integer errorState;

    @NotNull
    @Column(name = "timestamp", nullable = false, updatable = false)
    private LocalDateTime timestamp;

    public ErrorLog() {
        this.timestamp = LocalDateTime.now();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(Integer errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public Integer getErrorState() {
        return errorState;
    }

    public void setErrorState(Integer errorState) {
        this.errorState = errorState;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}