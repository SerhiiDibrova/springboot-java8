package hello.service;

import java.util.logging.Logger;

public class CBACT02C9910DisplayIOStatusService {

    private static final Logger logger = Logger.getLogger(CBACT02C9910DisplayIOStatusService.class.getName());

    public void displayIOStatus(String ioStatus, String ioStat1, String ioStat2) {
        try {
            if (!isNumeric(ioStatus) || ioStat1.equals("9")) {
                if (ioStat1.equals("9")) {
                    String ioStatus04 = formatIOStatus04(ioStat1, ioStat2);
                    logger.info("FILE STATUS IS: NNNN" + ioStatus04);
                } else {
                    logger.info("Invalid IO-STATUS");
                }
            } else if (isNumeric(ioStatus) && !ioStat1.equals("9")) {
                String ioStatus04 = formatIOStatus04(ioStatus);
                logger.info("FILE STATUS IS: NNNN" + ioStatus04);
            } else {
                logger.info("Invalid IO-STATUS or IO-STAT1");
            }
        } catch (Exception e) {
            logger.severe("Error occurred during displayIOStatus: " + e.getMessage());
            logger.info("Default behavior: FILE STATUS IS: NNNN0000");
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String formatIOStatus04(String ioStat1, String ioStat2) {
        String ioStatus04 = ioStat1.substring(0, 1) + "0" + ioStat2;
        return ioStatus04;
    }

    private String formatIOStatus04(String ioStatus) {
        String ioStatus04 = "00" + ioStatus.substring(ioStatus.length() - 2);
        return ioStatus04;
    }
}