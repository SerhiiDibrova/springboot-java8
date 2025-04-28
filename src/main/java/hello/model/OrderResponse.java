package hello.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderResponse {
    private Long orderId;
    private String userEmail;
    private List<Long> productIds;
    private String customerName;
    private BigDecimal totalAmount;
}