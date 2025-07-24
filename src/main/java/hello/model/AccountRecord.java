package hello.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountRecord {

    @Id
    private String acctId;
    private String acctActiveStatus;
    private double acctCurrBal;
    private LocalDateTime acctCreateDate;
    private LocalDateTime acctUpdateDate;
    private String acctType;
    private String acctCurrency;
    private double acctAvailableBal;
    private double acctHoldBal;

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getAcctActiveStatus() {
        return acctActiveStatus;
    }

    public void setAcctActiveStatus(String acctActiveStatus) {
        this.acctActiveStatus = acctActiveStatus;
    }

    public double getAcctCurrBal() {
        return acctCurrBal;
    }

    public void setAcctCurrBal(double acctCurrBal) {
        this.acctCurrBal = acctCurrBal;
    }

    public LocalDateTime getAcctCreateDate() {
        return acctCreateDate;
    }

    public void setAcctCreateDate(LocalDateTime acctCreateDate) {
        this.acctCreateDate = acctCreateDate;
    }

    public LocalDateTime getAcctUpdateDate() {
        return acctUpdateDate;
    }

    public void setAcctUpdateDate(LocalDateTime acctUpdateDate) {
        this.acctUpdateDate = acctUpdateDate;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getAcctCurrency() {
        return acctCurrency;
    }

    public void setAcctCurrency(String acctCurrency) {
        this.acctCurrency = acctCurrency;
    }

    public double getAcctAvailableBal() {
        return acctAvailableBal;
    }

    public void setAcctAvailableBal(double acctAvailableBal) {
        this.acctAvailableBal = acctAvailableBal;
    }

    public double getAcctHoldBal() {
        return acctHoldBal;
    }

    public void setAcctHoldBal(double acctHoldBal) {
        this.acctHoldBal = acctHoldBal;
    }
}