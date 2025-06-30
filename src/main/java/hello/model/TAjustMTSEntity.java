package hello.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a transaction with details such as date, time, and amount.
 */
public class TAjustMTSEntity {
    private LocalDateTime dateTime;
    private double amount;

    /**
     * Constructs a new TAjustMTSEntity object.
     * 
     * @param dateTime the date and time of the transaction
     * @param amount   the amount of the transaction
     */
    public TAjustMTSEntity(LocalDateTime dateTime, double amount) {
        setDateTime(dateTime);
        setAmount(amount);
    }

    /**
     * Gets the date and time of the transaction.
     * 
     * @return the date and time of the transaction
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time of the transaction.
     * 
     * @param dateTime the date and time of the transaction
     */
    public void setDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new NullPointerException("Date and time cannot be null");
        }
        this.dateTime = dateTime;
    }

    /**
     * Gets the amount of the transaction.
     * 
     * @return the amount of the transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the transaction.
     * 
     * @param amount the amount of the transaction
     */
    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    /**
     * Gets the date of the transaction as a string in the format "yyyy-MM-dd".
     * 
     * @return the date of the transaction
     */
    public String getDate() {
        return dateTime.format(DateTimeFormatter.ISO_DATE);
    }

    /**
     * Gets the time of the transaction as a string in the format "HH:mm:ss".
     * 
     * @return the time of the transaction
     */
    public String getTime() {
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    /**
     * Sets the date and time of the transaction from a string in the format "yyyy-MM-dd HH:mm:ss".
     * 
     * @param dateTime the date and time of the transaction
     */
    public void setDateTimeFromString(String dateTime) {
        try {
            this.dateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date and time format", e);
        }
    }
}