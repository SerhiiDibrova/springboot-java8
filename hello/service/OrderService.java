package hello.service;

import java.util.List;
import java.util.Map;

public class OrderService {

    @interface validator {}

    public double compute_total(Class<?> clazz, double value, Map<String, Object> fields) {
        List<Double> prices = (List<Double>) fields.get("products");
        if (prices == null) {
            throw new IllegalArgumentException("Products list cannot be null");
        }
        double total = prices.stream().mapToDouble(Double::doubleValue).sum();
        if (total <= 0) {
            throw new ValueError("Total must be greater than zero");
        }
        if (value != total) {
            throw new ValueError("Value does not match computed total");
        }
        return total;
    }
}