package hello.service;

public class IoStatusHandler {

    public void handleNonNumericIoStatus(String ioStatus) {
        if (ioStatus == null || ioStatus.isEmpty()) {
            throw new NullPointerException("Input ioStatus cannot be null or empty");
        }
        char firstChar = ioStatus.charAt(0);
        String twoBytesBinary = "00";
        String ioStatus04 = "0000";
        ioStatus04 = firstChar + ioStatus04.substring(1, 2) + twoBytesBinary;
        displayIoStatus(ioStatus04);
    }

    public void handleNumericIoStatus(String ioStatus) {
        if (ioStatus == null || ioStatus.isEmpty()) {
            throw new NullPointerException("Input ioStatus cannot be null or empty");
        }
        if (!ioStatus.matches("\\d+")) {
            throw new IllegalArgumentException("Input ioStatus must be numeric");
        }
        String ioStatus04 = "0000";
        ioStatus04 = ioStatus04.substring(0, 2) + ioStatus.substring(ioStatus.length() - 2);
        displayIoStatus(ioStatus04);
    }

    public void displayIoStatus(String ioStatus04) {
        System.out.println("FILE STATUS IS: " + ioStatus04);
    }
}