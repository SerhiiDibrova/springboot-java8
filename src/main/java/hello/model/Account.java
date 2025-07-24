package hello.model;

import java.util.Date;
import java.util.UUID;

public class Account {
    private UUID accountId;
    private boolean active;
    private double currentBalance;
    private double creditLimit;
    private Date creationDate;
    private Date modificationDate;
    private UUID groupId;

    public Account() {}

    public Account(UUID accountId, boolean active, double currentBalance, double creditLimit, Date creationDate, Date modificationDate, UUID groupId) {
        this.accountId = accountId;
        this.active = active;
        this.currentBalance = currentBalance;
        this.creditLimit = creditLimit;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.groupId = groupId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", active=" + active +
                ", currentBalance=" + currentBalance +
                ", creditLimit=" + creditLimit +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", groupId=" + groupId +
                '}';
    }
}