package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "error_log")
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "error_message", columnDefinition = "NVARCHAR(MAX)")
    private String errorMessage;

    @NotNull
    @Column(name = "error_severity")
    private Integer errorSeverity;

    @NotNull
    @Column(name = "error_state")
    private Integer errorState;

    @NotNull
    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}