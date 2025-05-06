package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponse {

    @NotNull
    @JsonProperty("id")
    private UUID id;

    @NotNull
    @Size(max = 255)
    @JsonProperty("name")
    private String name;

    @Size(max = 500)
    @JsonProperty("description")
    private String description = null;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @Min(value = 0)
    @JsonProperty("inStock")
    private Integer inStock;

    public ProductResponse(UUID id, String name, String description, BigDecimal price, Integer inStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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