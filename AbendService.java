package com.abend.service;

import com.abend.model.IoStatus;
import com.abend.model.IoStatus04;

/**
 * The AbendService class is designed to handle file input/output (I/O) status checking and display the status in a specific format.
 */
public class AbendService {

    /**
     * Displays the I/O status in a standardized format.
     * 
     * @param ioStatus the I/O status object to be displayed
     */
    public void displayIoStatus(IoStatus ioStatus) {
        if (ioStatus == null) {
            throw new NullPointerException("IoStatus object cannot be null");
        }
        if (!isNumeric(ioStatus.getIoStat1()) || ioStatus.getIoStat1().equals("9")) {
            handleNonNumericIoStatus(ioStatus);
        } else {
            handleNumericIoStatus(ioStatus);
        }
    }

    /**
     * Handles non-numeric I/O status.
     * 
     * @param ioStatus the I/O status object to be handled
     */
    public void handleNonNumericIoStatus(IoStatus ioStatus) {
        if (ioStatus == null) {
            throw new NullPointerException("IoStatus object cannot be null");
        }
        IoStatus04 ioStatus04 = new IoStatus04();
        ioStatus04.setIoStatus0401(ioStatus.getIoStat1());
        ioStatus04.setIoStatus0403("00");
        System.out.println("FILE STATUS IS: " + ioStatus04.getIoStatus0401() + ioStatus04.getIoStatus0403());
    }

    /**
     * Handles numeric I/O status.
     * 
     * @param ioStatus the I/O status object to be handled
     */
    public void handleNumericIoStatus(IoStatus ioStatus) {
        if (ioStatus == null) {
            throw new NullPointerException("IoStatus object cannot be null");
        }
        IoStatus04 ioStatus04 = new IoStatus04();
        ioStatus04.setIoStatus0401("00");
        ioStatus04.setIoStatus0403(ioStatus.getIoStat2());
        System.out.println("FILE STATUS IS: " + ioStatus04.getIoStatus0401() + ioStatus04.getIoStatus0403());
    }

    /**
     * Checks if a given string is numeric.
     * 
     * @param str the string to be checked
     * @return true if the string is numeric, false otherwise
     */
    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}