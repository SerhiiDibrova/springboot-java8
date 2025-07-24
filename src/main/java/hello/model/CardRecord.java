package hello.model;

import java.util.Objects;

public class CardRecord {
    private String cardNumber;
    private String accountID;
    private String cvvCode;
    private String embossedName;
    private String expirationDate;
    private boolean activeStatus;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be null or empty");
        }
        this.cardNumber = cardNumber;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        if (accountID == null || accountID.isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        this.accountID = accountID;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        if (cvvCode == null || cvvCode.isEmpty()) {
            throw new IllegalArgumentException("CVV code cannot be null or empty");
        }
        this.cvvCode = cvvCode;
    }

    public String getEmbossedName() {
        return embossedName;
    }

    public void setEmbossedName(String embossedName) {
        if (embossedName == null || embossedName.isEmpty()) {
            throw new IllegalArgumentException("Embossed name cannot be null or empty");
        }
        this.embossedName = embossedName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        if (expirationDate == null || expirationDate.isEmpty()) {
            throw new IllegalArgumentException("Expiration date cannot be null or empty");
        }
        this.expirationDate = expirationDate;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardRecord cardRecord = (CardRecord) o;
        return activeStatus == cardRecord.activeStatus &&
                Objects.equals(cardNumber, cardRecord.cardNumber) &&
                Objects.equals(accountID, cardRecord.accountID) &&
                Objects.equals(cvvCode, cardRecord.cvvCode) &&
                Objects.equals(embossedName, cardRecord.embossedName) &&
                Objects.equals(expirationDate, cardRecord.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, accountID, cvvCode, embossedName, expirationDate, activeStatus);
    }

    @Override
    public String toString() {
        return "CardRecord{" +
                "cardNumber='" + cardNumber + '\'' +
                ", accountID='" + accountID + '\'' +
                ", cvvCode='" + cvvCode + '\'' +
                ", embossedName='" + embossedName + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
    }
}