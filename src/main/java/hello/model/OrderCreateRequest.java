package hello.model;

import java.util.List;
import java.util.regex.Pattern;

public class OrderCreateRequest {
    private String userEmail;
    private List<Long> productIds;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        if (userEmail == null || !EMAIL_PATTERN.matcher(userEmail).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.userEmail = userEmail;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        if (productIds == null || productIds.isEmpty()) {
            throw new IllegalArgumentException("Product IDs cannot be null or empty");
        }
        this.productIds = productIds;
    }
}