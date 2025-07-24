package hello.service;

import hello.model.IoStatus;
import hello.model.IoStatus04;

public class DisplayIoStatusService {

    public IoStatus04 displayIoStatus(IoStatus ioStatus) {
        if (ioStatus == null) {
            throw new NullPointerException("Input IoStatus cannot be null");
        }
        if (ioStatus.getIoStat1() == null || ioStatus.getIoStat1().isEmpty() || ioStatus.getIoStat2() == null || ioStatus.getIoStat2().isEmpty()) {
            throw new IllegalArgumentException("Input IoStatus fields cannot be empty");
        }
        IoStatus04 ioStatus04 = new IoStatus04();
        try {
            if (!isNumeric(ioStatus.getIoStat1()) || ioStatus.getIoStat1().equals("9")) {
                ioStatus04 = formatIoStatus04NonNumeric(ioStatus);
            } else {
                ioStatus04 = formatIoStatus04Numeric(ioStatus);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error formatting IoStatus", e);
        }
        return ioStatus04;
    }

    private IoStatus04 formatIoStatus04NonNumeric(IoStatus ioStatus) {
        IoStatus04 ioStatus04 = new IoStatus04();
        ioStatus04.setIoStatus04(ioStatus.getIoStat1().substring(0, 1) + "00" + ioStatus.getIoStat2());
        String binary = Integer.toBinaryString(0);
        ioStatus04.setIoStatus04(ioStatus04.getIoStatus04().substring(0, 3) + binary.substring(binary.length() - 1) + binary.substring(binary.length() - 2, binary.length() - 1));
        return ioStatus04;
    }

    private IoStatus04 formatIoStatus04Numeric(IoStatus ioStatus) {
        IoStatus04 ioStatus04 = new IoStatus04();
        ioStatus04.setIoStatus04("0000");
        String numeric = ioStatus.getIoStat1();
        ioStatus04.setIoStatus04("00" + numeric.substring(numeric.length() - 2));
        return ioStatus04;
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