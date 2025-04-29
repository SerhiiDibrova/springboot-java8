package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "error_log")
public class ErrorLog {

    @Id
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "error_message", columnDefinition = "NVARCHAR(MAX)", nullable = true)
    private String errorMessage;

    @Column(name = "error_severity", nullable = true)
    private Integer errorSeverity;

    @Column(name = "error_state", nullable = true)
    private Integer errorState;

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
}