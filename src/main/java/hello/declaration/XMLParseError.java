package hello.declaration;

public class XMLParseError extends Exception {
    private int errorCode;

    public XMLParseError(String message) {
        super(message);
    }

    public XMLParseError(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}