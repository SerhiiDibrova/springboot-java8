package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IoStatus04 {
    @JsonProperty("status")
    private String status;

    public IoStatus04() {
        this.status = null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class DisplayIoStatusService {
    public IoStatus04 formatIoStatus(String ioStatus) {
        IoStatus04 ioStatus04 = new IoStatus04();
        if (isNumeric(ioStatus) || ioStatus.substring(0, 1).equals("9")) {
            if (ioStatus.substring(0, 1).equals("9")) {
                ioStatus04.setStatus("IO-STATUS is '9'");
            } else {
                ioStatus04.setStatus(ioStatus.substring(ioStatus.length() - 2));
            }
        } else {
            ioStatus04.setStatus("IO-STATUS is not numeric");
        }
        return ioStatus04;
    }

    private boolean isNumeric(String ioStatus) {
        try {
            Integer.parseInt(ioStatus);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}