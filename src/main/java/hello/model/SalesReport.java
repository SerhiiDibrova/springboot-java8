package hello.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SalesReport {
    private String orderIdentifier;
    private String customerFullName;
    private LocalDateTime orderDate;
    private double totalAmount;
    private String status;
    private String productIdentifier;
    private int quantity;
    private String paymentMethod;
    private LocalDateTime shipmentDate;
}