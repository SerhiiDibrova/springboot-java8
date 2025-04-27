package hello.model;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class SalesData implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    @NotNull(message = "Product name cannot be null or empty")
    private String productName;

    private int quantitySold;

    private double totalRevenue;

    @NotNull(message = "Sale date cannot be null or empty")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Sale date must be in the format YYYY-MM-DD")
    private String saleDate;

    public SalesData(int id, String productName, int quantitySold, double totalRevenue, String saleDate) {
        this.id = id;
        setProductName(productName);
        setQuantitySold(quantitySold);
        setTotalRevenue(totalRevenue);
        setSaleDate(saleDate);
    }
}