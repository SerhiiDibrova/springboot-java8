package hello.service;

import hello.model.IoStatus;
import hello.model.IoStatus04;

public class IoStatusDisplayService {

    public void displayIoStatus(IoStatus ioStatus) {
        if (ioStatus == null) {
            throw new NullPointerException("IoStatus object is null");
        }

        IoStatus04 ioStatus04 = new IoStatus04();
        try {
            if (!ioStatus.getIoStatus().matches("\\d+") || ioStatus.getIoStat1().equals("9")) {
                if (ioStatus.getIoStat1() == null || ioStatus.getIoStat1().isEmpty()) {
                    throw new IllegalArgumentException("IO-STAT1 is empty or null");
                }
                ioStatus04.setIoStatus04(ioStatus.getIoStat1().substring(0, 1) + "000");
                String twoBytesBinary = String.format("%02x", 0);
                ioStatus04.setIoStatus04(ioStatus04.getIoStatus04().substring(0, 2) + twoBytesBinary);
                System.out.println("FILE STATUS IS: " + ioStatus04.getIoStatus04());
            } else {
                ioStatus04.setIoStatus04("0000");
                if (ioStatus.getIoStatus() == null || ioStatus.getIoStatus().length() < 2) {
                    throw new IllegalArgumentException("IO-STATUS is empty or null or has less than 2 characters");
                }
                String lastTwoDigits = ioStatus.getIoStatus().substring(ioStatus.getIoStatus().length() - 2);
                ioStatus04.setIoStatus04("00" + lastTwoDigits);
                System.out.println("FILE STATUS IS: " + ioStatus04.getIoStatus04());
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}