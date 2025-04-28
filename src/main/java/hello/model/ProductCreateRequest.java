package hello.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProductCreateRequest {

    @NotNull
    private String name;

    @NotNull
    @Positive
    private Double price;

    @NotNull
    private String description;

    public ProductCreateRequest() {
    }

    public ProductCreateRequest(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}