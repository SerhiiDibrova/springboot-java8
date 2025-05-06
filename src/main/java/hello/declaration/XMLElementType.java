package hello.declaration;

import java.util.Map;
import java.util.List;

public class XMLElementType {
    public static final XMLElementType STRING = new XMLElementType("STRING");
    public static final XMLElementType BOOLEAN = new XMLElementType("BOOLEAN");
    public static final XMLElementType INTEGER = new XMLElementType("INTEGER");
    public static final XMLElementType FLOAT = new XMLElementType("FLOAT");
    public static final XMLElementType OBJECT = new XMLElementType("OBJECT");
    public static final XMLElementType LIST = new XMLElementType("LIST");
    public static final XMLElementType NULL = new XMLElementType("NULL");

    private String name;

    private XMLElementType(String name) {
        this.name = name;
    }

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
            throw new XMLParseError("Unsupported type: " + value.getClass().getSimpleName());
        }
    }

    public Object parse_element_value(String raw) throws XMLParseError {
        if (raw == null || raw.isEmpty()) {
            if (this == NULL) {
                return null;
            } else if (this == OBJECT) {
                return new java.util.HashMap<>();
            } else {
                throw new XMLParseError("Invalid XML schema for non-leaf node");
            }
        } else if (this == STRING) {
            return raw;
        } else if (this == INTEGER) {
            return Integer.valueOf(raw);
        } else if (this == FLOAT) {
            return Float.valueOf(raw);
        } else if (this == BOOLEAN) {
            String normalized_value = raw.trim().toLowerCase();
            if (normalized_value.equals("true") || normalized_value.equals("1")) {
                return true;
            } else if (normalized_value.equals("false") || normalized_value.equals("0")) {
                return false;
            } else {
                throw new XMLParseError("Invalid boolean format");
            }
        } else {
            throw new XMLParseError("Unsupported leaf type");
        }
    }

    public String getName() {
        return name;
    }
}

public class XMLParseError extends Exception {
    public XMLParseError(String message) {
        super(message);
    }
}