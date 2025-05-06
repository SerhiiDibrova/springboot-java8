package hello.declaration;

import java.util.HashMap;
import java.util.Map;

public class JSONType {
    private String field1;
    private Integer field2;
    private Map<String, Object> jsonData;

    public JSONType(String field1, Integer field2) {
        this.field1 = field1;
        this.field2 = field2;
        this.jsonData = new HashMap<>();
    }

    public void put(String key, Object value) {
        jsonData.put(key, value);
    }

    public Object get(String key) {
        return jsonData.get(key);
    }

    public Map<String, Object> getJsonData() {
        return jsonData;
    }

    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"field1\": \"").append(field1).append("\", ");
        jsonBuilder.append("\"field2\": ").append(field2).append(", ");
        for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
            jsonBuilder.append("\"").append(entry.getKey()).append("\": ");
            if (entry.getValue() instanceof String) {
                jsonBuilder.append("\"").append(entry.getValue()).append("\"");
            } else {
                jsonBuilder.append(entry.getValue());
            }
            jsonBuilder.append(", ");
        }
        if (jsonData.size() > 0 || field1 != null || field2 != null) {
            jsonBuilder.setLength(jsonBuilder.length() - 2);
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}