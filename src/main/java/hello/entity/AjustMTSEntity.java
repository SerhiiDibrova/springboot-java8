package hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
public class AjustMTSEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Cash desk is required")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid cash desk format")
    private String cashDesk;
    @NotNull(message = "Slot machine is required")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid slot machine format")
    private String slotMachine;
    @NotNull(message = "Transaction amount is required")
    private java.math.BigDecimal transactionAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCashDesk() {
        return cashDesk;
    }

    public void setCashDesk(String cashDesk) {
        this.cashDesk = cashDesk;
    }

    public String getSlotMachine() {
        return slotMachine;
    }

    public void setSlotMachine(String slotMachine) {
        this.slotMachine = slotMachine;
    }

    public java.math.BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(java.math.BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}