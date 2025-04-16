

package com.hello.model;

import java.time.LocalDateTime;

/**
 * Represents a record in the database table (equivalent to table_10).
 * This class has fields for the input value, the generated name, and the current date and time.
 * It provides getters and setters to represent a record in the database table.
 * It is used by the Proc30Service to create a new record to be inserted into the database table.
 */
public class Table10Record {
    private String inputValue;
    private String generatedName;
    private LocalDateTime currentDateTime;

    /**
     * Initializes the currentDateTime field with the current date and time.
     */
    public Table10Record() {
        this.currentDateTime = LocalDateTime.now();
    }

    /**
     * Gets the input value.
     * @return the input value
     */
    public String getInputValue() {
        return inputValue;
    }

    /**
     * Sets the input value.
     * @param inputValue the input value to set
     * @throws IllegalArgumentException if inputValue is null or empty
     */
    public void setInputValue(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException("Input value cannot be null or empty");
        }
        this.inputValue = inputValue;
    }

    /**
     * Gets the generated name.
     * @return the generated name
     */
    public String getGeneratedName() {
        return generatedName;
    }

    /**
     * Sets the generated name.
     * @param generatedName the generated name to set
     * @throws IllegalArgumentException if generatedName is null or empty
     */
    public void setGeneratedName(String generatedName) {
        if (generatedName == null || generatedName.isEmpty()) {
            throw new IllegalArgumentException("Generated name cannot be null or empty");
        }
        this.generatedName = generatedName;
    }

    /**
     * Gets the current date and time.
     * @return the current date and time
     */
    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    /**
     * Sets the current date and time.
     * @param currentDateTime the current date and time to set
     */
    public void setCurrentDateTime(LocalDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }
}