package com.io.status.display.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IoStatusDisplayService {

    private static final Logger logger = LoggerFactory.getLogger(IoStatusDisplayService.class);

    public void displayIoStatus(String ioStatus) {
        try {
            if (ioStatus == null || ioStatus.isEmpty()) {
                throw new IllegalArgumentException("I/O status cannot be null or empty");
            }
            if (!isNumeric(ioStatus) || ioStatus.startsWith("9")) {
                handleNonNumericIoStatus(ioStatus);
            } else {
                handleNumericIoStatus(ioStatus);
            }
        } catch (Exception e) {
            logger.error("Error displaying I/O status", e);
        }
    }

    private void handleNonNumericIoStatus(String ioStatus) {
        if (ioStatus.length() < 2) {
            throw new IllegalArgumentException("I/O status must be at least 2 characters long");
        }
        String ioStatus04 = ioStatus.substring(0, 1) + "000";
        int twoBytesBinary = 0;
        int twoBytesRight = Integer.parseInt(ioStatus.substring(1));
        ioStatus04 = ioStatus04.substring(0, 2) + String.format("%02d", twoBytesBinary) + ioStatus04.substring(4);
        logger.info("FILE STATUS IS: {}", ioStatus04);
    }

    private void handleNumericIoStatus(String ioStatus) {
        if (ioStatus.length() < 2) {
            throw new IllegalArgumentException("I/O status must be at least 2 characters long");
        }
        String ioStatus04 = "0000";
        ioStatus04 = ioStatus04.substring(0, 2) + ioStatus.substring(ioStatus.length() - 2);
        logger.info("FILE STATUS IS: {}", ioStatus04);
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}