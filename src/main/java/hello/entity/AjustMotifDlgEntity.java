package hello.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TAjustMotifDlg")
public class AjustMotifDlgEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cashDesk")
    private String cashDesk;

    @Column(name = "slotMachine")
    private String slotMachine;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "transactionInfo")
    private String transactionInfo;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(String transactionInfo) {
        this.transactionInfo = transactionInfo;
    }
}