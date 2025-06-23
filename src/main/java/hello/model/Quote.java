package hello.model;

import hello.model.Value;

public class Quote {
    private String type;
    private Value value;

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        this.value = value;
    }

    public Quote() {

    }

    public void method_c() {
        if (this.type == null || this.value == null) {
            throw new IllegalStateException("Type and value must be set before calling method_c");
        }
        System.out.println("Method_c called with type: " + this.type + " and value: " + this.value);
    }
}