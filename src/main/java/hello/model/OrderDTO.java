package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class OrderDTO {
    private long id;
    private String name;

    @NotNull
    @Email
    @JsonProperty("user_email")
    private String userEmail;

    @NotNull
    @Size(min = 1)
    @JsonProperty("product_ids")
    private List<Long> productIds;

    public OrderDTO() {}

    public OrderDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public OrderDTO(long id, String name, String userEmail, List<Long> productIds) {
        this.id = id;
        this.name = name;
        this.userEmail = userEmail;
        this.productIds = productIds;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public List<Long> getProductIds() { return productIds; }
    public void setProductIds(List<Long> productIds) { this.productIds = productIds; }

    public OrderDB toEntity() {
        return new OrderDB(id, name, userEmail, productIds);
    }
}