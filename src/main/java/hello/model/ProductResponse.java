package hello.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}