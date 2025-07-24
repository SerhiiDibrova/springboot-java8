package hello.model;

public class TwoBytesAlpha {
    private Byte byte1;
    private Byte byte2;

    public TwoBytesAlpha() {}

    public TwoBytesAlpha(Byte byte1, Byte byte2) {
        this.byte1 = byte1;
        this.byte2 = byte2;
    }

    public Byte getByte1() {
        return byte1;
    }

    public void setByte1(Byte byte1) {
        this.byte1 = byte1;
    }

    public Byte getByte2() {
        return byte2;
    }

    public void setByte2(Byte byte2) {
        this.byte2 = byte2;
    }
}