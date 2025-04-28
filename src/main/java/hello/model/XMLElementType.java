package hello.model;

import java.util.List;
import java.util.Optional;

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

    public static XMLElementType from_value(Object value) {
        if (value instanceof String) {
            return STRING;
        } else if (value instanceof Boolean) {
            return BOOLEAN;
        } else if (value instanceof Integer) {
            return INTEGER;
        } else if (value instanceof Float) {
            return FLOAT;
        } else if (value instanceof List) {
            return LIST;
        } else if (value == null) {
            return NULL;
        } else {
            throw new XMLParseError("Unsupported type: " + value.getClass().getName());
        }
    }

    public Object parse_element_value(Optional<String> value) {
        if (!value.isPresent() || value.get().isEmpty()) {
            return NULL;
        }
        String val = value.get();
        try {
            if (val.equalsIgnoreCase("true") || val.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(val);
            } else if (val.matches("-?\\d+")) {
                return Integer.parseInt(val);
            } else if (val.matches("-?\\d+(\\.\\d+)?")) {
                return Float.parseFloat(val);
            } else {
                return val;
            }
        } catch (Exception e) {
            throw new XMLParseError("Invalid value: " + val);
        }
    }
}