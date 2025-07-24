package hello.model;

import java.util.Date;

/**
 * This class represents the account record information.
 */
public class AccountRecord {

    private String acctId;
    private String acctActiveStatus;
    private double acctCurrBal;
    private double acctCreditLimit;
    private double acctCashCreditLimit;
    private Date acctOpenDate;
    private Date acctExpiraionDate;
    private Date acctReissueDate;
    private double acctCurrCycCredit;
    private double acctCurrCycDebit;
    private String acctGroupId;

    /**
     * Constructor to initialize the object with the required fields.
     * 
     * @param acctId              the account ID
     * @param acctActiveStatus    the account active status
     * @param acctCurrBal         the account current balance
     * @param acctCreditLimit     the account credit limit
     * @param acctCashCreditLimit the account cash credit limit
     * @param acctOpenDate        the account open date
     * @param acctExpiraionDate   the account expiration date
     * @param acctReissueDate     the account reissue date
     * @param acctCurrCycCredit   the account current cycle credit
     * @param acctCurrCycDebit    the account current cycle debit
     * @param acctGroupId         the account group ID
     */
    public AccountRecord(String acctId, String acctActiveStatus, double acctCurrBal, double acctCreditLimit,
            double acctCashCreditLimit, Date acctOpenDate, Date acctExpiraionDate, Date acctReissueDate,
            double acctCurrCycCredit, double acctCurrCycDebit, String acctGroupId) {
        this.acctId = acctId;
        this.acctActiveStatus = acctActiveStatus;
        this.acctCurrBal = acctCurrBal;
        this.acctCreditLimit = acctCreditLimit;
        this.acctCashCreditLimit = acctCashCreditLimit;
        this.acctOpenDate = acctOpenDate;
        this.acctExpiraionDate = acctExpiraionDate;
        this.acctReissueDate = acctReissueDate;
        this.acctCurrCycCredit = acctCurrCycCredit;
        this.acctCurrCycDebit = acctCurrCycDebit;
        this.acctGroupId = acctGroupId;
    }

    /**
     * Gets the account ID.
     * 
     * @return the account ID
     */
    public String getAcctId() {
        return acctId;
    }

    /**
     * Sets the account ID.
     * 
     * @param acctId the account ID to set
     */
    public void setAcctId(String acctId) {
        if (acctId == null) {
            throw new NullPointerException("Account ID cannot be null");
        }
        this.acctId = acctId;
    }

    /**
     * Gets the account active status.
     * 
     * @return the account active status
     */
    public String getAcctActiveStatus() {
        return acctActiveStatus;
    }

    /**
     * Sets the account active status.
     * 
     * @param acctActiveStatus the account active status to set
     */
    public void setAcctActiveStatus(String acctActiveStatus) {
        if (acctActiveStatus == null) {
            throw new NullPointerException("Account active status cannot be null");
        }
        this.acctActiveStatus = acctActiveStatus;
    }

    /**
     * Gets the account current balance.
     * 
     * @return the account current balance
     */
    public double getAcctCurrBal() {
        return acctCurrBal;
    }

    /**
     * Sets the account current balance.
     * 
     * @param acctCurrBal the account current balance to set
     */
    public void setAcctCurrBal(double acctCurrBal) {
        if (acctCurrBal < 0) {
            throw new IllegalArgumentException("Account current balance cannot be negative");
        }
        this.acctCurrBal = acctCurrBal;
    }

    /**
     * Gets the account credit limit.
     * 
     * @return the account credit limit
     */
    public double getAcctCreditLimit() {
        return acctCreditLimit;
    }

    /**
     * Sets the account credit limit.
     * 
     * @param acctCreditLimit the account credit limit to set
     */
    public void setAcctCreditLimit(double acctCreditLimit) {
        if (acctCreditLimit < 0) {
            throw new IllegalArgumentException("Account credit limit cannot be negative");
        }
        this.acctCreditLimit = acctCreditLimit;
    }

    /**
     * Gets the account cash credit limit.
     * 
     * @return the account cash credit limit
     */
    public double getAcctCashCreditLimit() {
        return acctCashCreditLimit;
    }

    /**
     * Sets the account cash credit limit.
     * 
     * @param acctCashCreditLimit the account cash credit limit to set
     */
    public void setAcctCashCreditLimit(double acctCashCreditLimit) {
        if (acctCashCreditLimit < 0) {
            throw new IllegalArgumentException("Account cash credit limit cannot be negative");
        }
        this.acctCashCreditLimit = acctCashCreditLimit;
    }

    /**
     * Gets the account open date.
     * 
     * @return the account open date
     */
    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    /**
     * Sets the account open date.
     * 
     * @param acctOpenDate the account open date to set
     */
    public void setAcctOpenDate(Date acctOpenDate) {
        if (acctOpenDate == null) {
            throw new NullPointerException("Account open date cannot be null");
        }
        this.acctOpenDate = acctOpenDate;
    }

    /**
     * Gets the account expiration date.
     * 
     * @return the account expiration date
     */
    public Date getAcctExpiraionDate() {
        return acctExpiraionDate;
    }

    /**
     * Sets the account expiration date.
     * 
     * @param acctExpiraionDate the account expiration date to set
     */
    public void setAcctExpiraionDate(Date acctExpiraionDate) {
        if (acctExpiraionDate == null) {
            throw new NullPointerException("Account expiration date cannot be null");
        }
        this.acctExpiraionDate = acctExpiraionDate;
    }

    /**
     * Gets the account reissue date.
     * 
     * @return the account reissue date
     */
    public Date getAcctReissueDate() {
        return acctReissueDate;
    }

    /**
     * Sets the account reissue date.
     * 
     * @param acctReissueDate the account reissue date to set
     */
    public void setAcctReissueDate(Date acctReissueDate) {
        if (acctReissueDate == null) {
            throw new NullPointerException("Account reissue date cannot be null");
        }
        this.acctReissueDate = acctReissueDate;
    }

    /**
     * Gets the account current cycle credit.
     * 
     * @return the account current cycle credit
     */
    public double getAcctCurrCycCredit() {
        return acctCurrCycCredit;
    }

    /**
     * Sets the account current cycle credit.
     * 
     * @param acctCurrCycCredit the account current cycle credit to set
     */
    public void setAcctCurrCycCredit(double acctCurrCycCredit) {
        if (acctCurrCycCredit < 0) {
            throw new IllegalArgumentException("Account current cycle credit cannot be negative");
        }
        this.acctCurrCycCredit = acctCurrCycCredit;
    }

    /**
     * Gets the account current cycle debit.
     * 
     * @return the account current cycle debit
     */
    public double getAcctCurrCycDebit() {
        return acctCurrCycDebit;
    }

    /**
     * Sets the account current cycle debit.
     * 
     * @param acctCurrCycDebit the account current cycle debit to set
     */
    public void setAcctCurrCycDebit(double acctCurrCycDebit) {
        if (acctCurrCycDebit < 0) {
            throw new IllegalArgumentException("Account current cycle debit cannot be negative");
        }
        this.acctCurrCycDebit = acctCurrCycDebit;
    }

    /**
     * Gets the account group ID.
     * 
     * @return the account group ID
     */
    public String getAcctGroupId() {
        return acctGroupId;
    }

    /**
     * Sets the account group ID.
     * 
     * @param acctGroupId the account group ID to set
     */
    public void setAcctGroupId(String acctGroupId) {
        if (acctGroupId == null) {
            throw new NullPointerException("Account group ID cannot be null");
        }
        this.acctGroupId = acctGroupId;
    }
}