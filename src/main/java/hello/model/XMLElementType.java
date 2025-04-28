package hello.model;

import java.util.Optional;
import java.util.Map;

public enum XMLElementType {
    NULL,
    OBJECT,
    STRING,
    INTEGER,
    FLOAT,
    BOOLEAN;

    public static XMLElementType fromValue(Object value) throws XMLParseError {
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
        } else {
            throw new XMLParseError("Unsupported type: " + value.getClass().getName());
        }
    }

    public Object parse_element_value(Optional<String> value) throws XMLParseError {
        if (!value.isPresent() || value.get().isEmpty()) {
            if (this == NULL) {
                return null;
            } else if (this == OBJECT) {
                return Map.of();
            } else {
                throw new XMLParseError("Invalid XML schema for non-leaf node");
            }
        }

        switch (this) {
            case STRING:
                return value.get();
            case INTEGER:
                return Integer.valueOf(value.get());
            case FLOAT:
                return Float.valueOf(value.get());
            case BOOLEAN:
                String boolValue = value.get().trim().toLowerCase();
                if ("true".equals(boolValue) || "1".equals(boolValue) || "yes".equals(boolValue)) {
                    return true;
                } else if ("false".equals(boolValue) || "0".equals(boolValue) || "no".equals(boolValue)) {
                    return false;
                } else {
                    throw new XMLParseError("Invalid boolean value: " + value.get());
                }
            default:
                throw new XMLParseError("Unsupported leaf type: " + this);
        }
    }
}

package hello.model;

public class XMLParseError extends Exception {
    public XMLParseError(String message) {
        super(message);
    }
}