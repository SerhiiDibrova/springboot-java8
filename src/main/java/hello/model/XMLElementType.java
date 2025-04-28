package hello.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import org.lxml.Element;

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
        } else if (value instanceof Map) {
            return OBJECT;
        } else if (value instanceof List) {
            return LIST;
        } else {
            throw new XMLParseError("Unsupported type: " + value.getClass().getName());
        }
    }

    public Object parse_element_value(Optional<String> value) throws XMLParseError {
        if (!value.isPresent() || value.get().isEmpty()) {
            return null;
        }
        String strValue = value.get();
        try {
            if ("true".equalsIgnoreCase(strValue) || "false".equalsIgnoreCase(strValue)) {
                return Boolean.parseBoolean(strValue);
            } else if (strValue.matches("-?\\d+")) {
                return Integer.parseInt(strValue);
            } else if (strValue.matches("-?\\d+(\\.\\d+)?")) {
                return Float.parseFloat(strValue);
            } else {
                return strValue;
            }
        } catch (NumberFormatException e) {
            throw new XMLParseError("Invalid value for parsing: " + strValue);
        }
    }

    public Element parse_json_to_element(String json) throws XMLParseError {
        // Implementation for converting JSON to lxml Element
        // This is a placeholder for the actual implementation
        return new Element("placeholder");
    }
}

class XMLParseError extends Exception {
    public XMLParseError(String message) {
        super(message);
    }
}