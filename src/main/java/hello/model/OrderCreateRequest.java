package hello.model;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderCreateRequest {
    @NotEmpty(message = "User email cannot be empty")
    @Email(message = "Invalid email format")
    private String userEmail;

    @NotNull(message = "Product IDs cannot be null")
    private List<@NotNull(message = "Product ID cannot be null") Long> productIds;

    public OrderCreateRequest() {
    }

    public OrderCreateRequest(String userEmail, List<Long> productIds) {
        this.userEmail = userEmail;
        this.productIds = productIds;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}