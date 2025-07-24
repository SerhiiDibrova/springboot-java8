package hello.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class IoStatus {
    @NotNull
    @Size(min = 1, max = 1)
    private String ioStat1;
    @NotNull
    @Size(min = 2, max = 2)
    private String ioStat2;
    private boolean numeric;

    public IoStatus() {
        this.numeric = false;
    }

    public String getIoStat1() {
        return ioStat1;
    }

    public void setIoStat1(String ioStat1) {
        if (ioStat1 == null) {
            throw new NullPointerException("ioStat1 cannot be null");
        }
        if (ioStat1.length() != 1) {
            throw new IllegalArgumentException("ioStat1 must be 1 character long");
        }
        this.ioStat1 = ioStat1;
    }

    public String getIoStat2() {
        return ioStat2;
    }

    public void setIoStat2(String ioStat2) {
        if (ioStat2 == null) {
            throw new NullPointerException("ioStat2 cannot be null");
        }
        if (ioStat2.length() != 2) {
            throw new IllegalArgumentException("ioStat2 must be 2 characters long");
        }
        this.ioStat2 = ioStat2;
    }

    public boolean isNumeric() {
        return numeric;
    }

    public void setNumeric(boolean numeric) {
        this.numeric = numeric;
    }
}