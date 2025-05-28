package hello.entity;

public class AtmResponse {
    private boolean result;

    public AtmResponse() {}

    public AtmResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}