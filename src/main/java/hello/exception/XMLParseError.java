package hello.exception;

public class XMLParseError extends Exception {
    public XMLParseError(String message) {
        super(message);
    }

    public static XMLParseError unsupportedTypeError(String type) {
        return new XMLParseError("Unsupported type: " + type);
    }

    public static XMLParseError missingElementError(String element) {
        return new XMLParseError("Missing required element: " + element);
    }

    public static XMLParseError invalidFormatError(String format) {
        return new XMLParseError("Invalid format: " + format);
    }
}