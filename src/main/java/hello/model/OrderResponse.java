package hello.model;

import lombok.Data;
import java.util.List;

@Data
public class OrderResponse {
    private Long orderId;
    private String userEmail;
    private List<Long> productIds;
}