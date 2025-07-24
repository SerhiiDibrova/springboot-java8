package hello.model;

public class IoStatus {
    private char ioStat1;
    private char ioStat2;

    public IoStatus() {}

    public IoStatus(char ioStat1, char ioStat2) {
        this.ioStat1 = ioStat1;
        this.ioStat2 = ioStat2;
    }

    public char getIoStat1() {
        return ioStat1;
    }

    public void setIoStat1(char ioStat1) {
        this.ioStat1 = ioStat1;
    }

    public char getIoStat2() {
        return ioStat2;
    }

    public void setIoStat2(char ioStat2) {
        this.ioStat2 = ioStat2;
    }

    public String getIoStatus() {
        return String.valueOf(ioStat1) + String.valueOf(ioStat2);
    }

    public boolean isNumeric() {
        try {
            Integer.parseInt(String.valueOf(ioStat1));
            Integer.parseInt(String.valueOf(ioStat2));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isFirstCharEquals9() {
        return ioStat1 == '9';
    }

    public String formatIoStatusMessage() {
        if (isNumeric()) {
            if (isFirstCharEquals9()) {
                return "I/O status is numeric and first character equals 9: " + getIoStatus();
            } else {
                return "I/O status is numeric: " + getIoStatus();
            }
        } else {
            return "I/O status is not numeric: " + getIoStatus();
        }
    }

    public void displayIoStatus() {
        System.out.println(formatIoStatusMessage());
    }
}