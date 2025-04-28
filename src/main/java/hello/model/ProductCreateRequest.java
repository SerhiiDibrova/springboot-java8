package hello.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductCreateRequest {
    
    @NotNull
    private String name;
    
    @NotNull
    private String description;
    
    @NotNull
    private BigDecimal price;
    
    @NotNull
    private Boolean inStock;

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

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }
}