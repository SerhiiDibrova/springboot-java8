package hello.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public enum XMLElementType {
    NULL,
    OBJECT,
    STRING,
    INTEGER,
    FLOAT,
    BOOLEAN;

    public static XMLElementType from_value(Object value) {
        if (Objects.isNull(value)) {
            return NULL;
        } else if (value instanceof String) {
            return STRING;
        } else if (value instanceof Integer) {
            return INTEGER;
        } else if (value instanceof Float) {
            return FLOAT;
        } else if (value instanceof Boolean) {
            return BOOLEAN;
        } else if (value instanceof Map) {
            return OBJECT;
        } else {
            throw new UnsupportedOperationException("Unsupported type: " + value.getClass());
        }
    }

    public Object parseElementValue(String value) {
        if (Objects.isNull(value)) {
            if (this == NULL) {
                return null;
            } else if (this == OBJECT) {
                return new HashMap<>();
            } else {
                throw new ValueException("Invalid XML file schema");
            }
        } else {
            switch (this) {
                case STRING:
                    return value;
                case INTEGER:
                    return Integer.parseInt(value);
                case FLOAT:
                    return Float.parseFloat(value);
                case BOOLEAN:
                    return Boolean.parseBoolean(value);
                case OBJECT:
                    return new HashMap<>();
                case NULL:
                    throw new ValueException("Unsupported Etree element type: " + this);
                default:
                    throw new UnsupportedOperationException("Unsupported type: " + this);
            }
        }
    }

    private static class ValueException extends RuntimeException {
        public ValueException(String message) {
            super(message);
        }
    }
}