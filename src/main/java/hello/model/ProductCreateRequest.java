package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductCreateRequest {

    @NotNull
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @NotNull
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @JsonProperty("in_stock")
    private Integer inStock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }
}