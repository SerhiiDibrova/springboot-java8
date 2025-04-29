package hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Entity
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String errorMessage;

    @NotNull
    @Column(nullable = false)
    private String errorSeverity;

    @NotNull
    @Column(nullable = false)
    private String errorState;

    public ErrorLog() {
    }

    public ErrorLog(String errorMessage, String errorSeverity, String errorState) {
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

    public String getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(String errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public String getErrorState() {
        return errorState;
    }

    public void setErrorState(String errorState) {
        this.errorState = errorState;
    }

    @Override
    public String toString() {
        return "ErrorLog{" +
                "id=" + id +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorSeverity='" + errorSeverity + '\'' +
                ", errorState='" + errorState + '\'' +
                '}';
    }
}