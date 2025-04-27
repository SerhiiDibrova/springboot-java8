package hello.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SalesData")
@Getter
@Setter
public class SalesData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "product_name")
    private String productName;

    @NotNull
    @Positive
    @Column(name = "quantity_sold")
    private Integer quantitySold;

    @NotNull
    @Column(name = "sale_date")
    private LocalDate saleDate;

    @NotNull
    @Positive
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    public SalesData() {
    }
}