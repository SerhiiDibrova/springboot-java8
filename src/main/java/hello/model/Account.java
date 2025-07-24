package hello.model;

import java.util.Date;
import java.util.UUID;

public class Account {
    private UUID accountId;
    private boolean isActive;
    private double currentBalance;
    private double creditLimit;
    private Date creationDate;
    private Date modificationDate;
    private UUID groupId;

    public Account() {}

    public Account(UUID accountId, boolean isActive, double currentBalance, double creditLimit, Date creationDate, Date modificationDate, UUID groupId) {
        this.accountId = accountId;
        this.isActive = isActive;
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
        if (accountId == null) {
            throw new NullPointerException("Account ID cannot be null");
        }
        this.accountId = accountId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        if (currentBalance < 0) {
            throw new IllegalArgumentException("Current balance cannot be negative");
        }
        this.currentBalance = currentBalance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        if (creditLimit < 0) {
            throw new IllegalArgumentException("Credit limit cannot be negative");
        }
        this.creditLimit = creditLimit;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        if (creationDate == null) {
            throw new NullPointerException("Creation date cannot be null");
        }
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        if (modificationDate == null) {
            throw new NullPointerException("Modification date cannot be null");
        }
        this.modificationDate = modificationDate;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        if (groupId == null) {
            throw new NullPointerException("Group ID cannot be null");
        }
        this.groupId = groupId;
    }
}