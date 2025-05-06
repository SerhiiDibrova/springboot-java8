package hello.declaration;

import java.util.Map;
import java.util.List;

public class XMLParseError extends Exception {
    public XMLParseError(String message) {
        super(message);
    }
}

public class XMLElementType {
    public static final XMLElementType STRING = new XMLElementType();
    public static final XMLElementType BOOLEAN = new XMLElementType();
    public static final XMLElementType INTEGER = new XMLElementType();
    public static final XMLElementType FLOAT = new XMLElementType();
    public static final XMLElementType OBJECT = new XMLElementType();
    public static final XMLElementType LIST = new XMLElementType();
    public static final XMLElementType NULL = new XMLElementType();

    public static XMLElementType from_value(Object value) throws XMLParseError {
        if (value instanceof String) {
            return STRING;
        } else if (value instanceof Boolean) {
            return BOOLEAN;
        } else if (value instanceof Integer) {
            return INTEGER;
        } else if (value instanceof Float) {
            return FLOAT;
        } else if (value instanceof Map) {
            return OBJECT;
        } else if (value instanceof List) {
            return LIST;
        } else if (value == null) {
            return NULL;
        } else {
            throw new XMLParseError("Unsupported type: " + value.getClass().getName());
        }
    }
}