package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IoStatus04 {
    @JsonProperty("ioStatus0401")
    private String ioStatus0401;

    @JsonProperty("ioStatus0403")
    private String ioStatus0403;

    public IoStatus04() {}

    public IoStatus04(String ioStatus0401, String ioStatus0403) {
        this.ioStatus0401 = ioStatus0401;
        this.ioStatus0403 = ioStatus0403;
    }

    public String getIoStatus0401() {
        return ioStatus0401;
    }

    public void setIoStatus0401(String ioStatus0401) {
        this.ioStatus0401 = ioStatus0401;
    }

    public String getIoStatus0403() {
        return ioStatus0403;
    }

    public void setIoStatus0403(String ioStatus0403) {
        this.ioStatus0403 = ioStatus0403;
    }

    public static IoStatus04 fromIoStatus(String ioStatus, String ioStat1, String ioStat2) {
        if (ioStatus == null || ioStat1 == null || ioStat2 == null) {
            throw new NullPointerException("ioStatus, ioStat1, and ioStat2 cannot be null");
        }

        IoStatus04 ioStatus04 = new IoStatus04();

        if (!ioStatus.matches("\\d+") || ioStat1.startsWith("9")) {
            if (ioStat1.length() > 0) {
                ioStatus04.setIoStatus0401(ioStat1.substring(0, 1));
            } else {
                ioStatus04.setIoStatus0401("");
            }
            ioStatus04.setIoStatus0403(ioStat2);
        } else {
            ioStatus04.setIoStatus0401("00");
            if (ioStatus.length() >= 2) {
                ioStatus04.setIoStatus0403(ioStatus.substring(ioStatus.length() - 2));
            } else {
                ioStatus04.setIoStatus0403("");
            }
        }
        return ioStatus04;
    }
}