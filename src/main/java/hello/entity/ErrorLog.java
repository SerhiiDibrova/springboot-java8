package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "error_log", uniqueConstraints = @UniqueConstraint(columnNames = "errorMessage"))
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String errorMessage;

    @NotNull
    @Column(nullable = false)
    private int errorSeverity;

    @NotNull
    @Column(nullable = false)
    private int errorState;

    public ErrorLog() {
    }

    public ErrorLog(String errorMessage, int errorSeverity, int errorState) {
        this.errorMessage = errorMessage;
        this.errorSeverity = errorSeverity;
        this.errorState = errorState;
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

    public int getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(int errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public int getErrorState() {
        return errorState;
    }

    public void setErrorState(int errorState) {
        this.errorState = errorState;
    }
}