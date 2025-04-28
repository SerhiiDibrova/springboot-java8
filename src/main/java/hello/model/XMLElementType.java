package hello.model;

import hello.declaration.XMLParseError;
import java.util.Objects;

public class XMLElementType {
    public static final XMLElementType STRING = new XMLElementType("STRING");
    public static final XMLElementType BOOLEAN = new XMLElementType("BOOLEAN");
    public static final XMLElementType INTEGER = new XMLElementType("INTEGER");
    public static final XMLElementType FLOAT = new XMLElementType("FLOAT");
    public static final XMLElementType OBJECT = new XMLElementType("OBJECT");
    public static final XMLElementType LIST = new XMLElementType("LIST");
    public static final XMLElementType NULL = new XMLElementType("NULL");

    private String type;

    private XMLElementType(String type) {
        this.type = type;
    }

    public static XMLElementType from_value(Object value) throws XMLParseError {
        if (value == null) {
            return NULL;
        } else if (value instanceof String) {
            return STRING;
        } else if (value instanceof Boolean) {
            return BOOLEAN;
        } else if (value instanceof Integer) {
            return INTEGER;
        } else if (value instanceof Float) {
            return FLOAT;
        } else if (value instanceof Object) {
            return OBJECT;
        } else {
            throw new XMLParseError("Unsupported type: " + value.getClass().getName());
        }
    }
}

class XMLParser {
    public Object parse_element_value(String value) throws XMLParseError {
        if (Objects.isNull(value) || value.isEmpty()) {
            return null;
        }
        try {
            if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(value);
            } else if (value.matches("-?\\d+")) {
                return Integer.parseInt(value);
            } else if (value.matches("-?\\d+\\.\\d+")) {
                return Float.parseFloat(value);
            } else {
                return value; // Treat as string
            }
        } catch (Exception e) {
            throw new XMLParseError("Invalid value: " + value);
        }
    }
}