package hello.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JSONType {
    @NotNull
    @Size(min = 1, max = 100)
    private String attribute1;

    @NotNull
    private int attribute2;

    private boolean attribute3;

    public JSONType() {
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public int getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(int attribute2) {
        this.attribute2 = attribute2;
    }

    public boolean isAttribute3() {
        return attribute3;
    }

    public void setAttribute3(boolean attribute3) {
        this.attribute3 = attribute3;
    }
}