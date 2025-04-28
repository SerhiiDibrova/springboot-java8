package hello.model;

import java.util.Optional;
import java.util.HashMap;
import hello.model.XMLParseError;

public class XMLElementType {
    public static final XMLElementType NULL = new XMLElementType("NULL");
    public static final XMLElementType OBJECT = new XMLElementType("OBJECT");
    public static final XMLElementType STRING = new XMLElementType("STRING");
    public static final XMLElementType INTEGER = new XMLElementType("INTEGER");
    public static final XMLElementType FLOAT = new XMLElementType("FLOAT");
    public static final XMLElementType BOOLEAN = new XMLElementType("BOOLEAN");
    public static final XMLElementType LIST = new XMLElementType("LIST");

    private String type;

    private XMLElementType(String type) {
        this.type = type;
    }

    public static XMLElementType from_value(Object value) {
        if (value == null) {
            return NULL;
        } else if (value instanceof String) {
            return STRING;
        } else if (value instanceof Integer) {
            return INTEGER;
        } else if (value instanceof Float) {
            return FLOAT;
        } else if (value instanceof Boolean) {
            return BOOLEAN;
        } else if (value instanceof HashMap) {
            return OBJECT;
        } else if (value instanceof Iterable) {
            return LIST;
        }
        throw new XMLParseError("Unsupported type: " + value.getClass().getName());
    }

    public Object parse_element_value(Optional<String> value) {
        if (value.isEmpty()) {
            if (this == NULL) {
                return null;
            } else if (this == OBJECT) {
                return new HashMap<>();
            } else {
                throw new XMLParseError("Invalid XML schema for non-leaf node");
            }
        }
        String val = value.get();
        switch (this.type) {
            case "STRING":
                return val;
            case "INTEGER":
                return Integer.valueOf(val);
            case "FLOAT":
                return Float.valueOf(val);
            case "BOOLEAN":
                String normalized = val.trim().toLowerCase();
                if ("true".equals(normalized) || "1".equals(normalized) || "yes".equals(normalized)) {
                    return true;
                } else if ("false".equals(normalized) || "0".equals(normalized) || "no".equals(normalized)) {
                    return false;
                }
                throw new XMLParseError("Invalid boolean value: " + val);
            default:
                throw new XMLParseError("Unsupported leaf type: " + this.type);
        }
    }
}