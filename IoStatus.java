package com.dto;

public final class IoStatus {
    private final String ioStat1;
    private final String ioStat2;

    public IoStatus(String ioStat1, String ioStat2) {
        if (ioStat1 == null || ioStat1.isEmpty()) {
            throw new IllegalArgumentException("ioStat1 cannot be null or empty");
        }
        if (ioStat2 == null || ioStat2.isEmpty()) {
            throw new IllegalArgumentException("ioStat2 cannot be null or empty");
        }
        this.ioStat1 = ioStat1;
        this.ioStat2 = ioStat2;
    }

    public String getIoStat1() {
        return ioStat1;
    }

    public String getIoStat2() {
        return ioStat2;
    }
}