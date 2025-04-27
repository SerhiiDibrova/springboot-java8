package hello.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class SalesReportModel {
    @Id
    private String orderIdentifier;
    private String customerFullName;
    private LocalDate orderDate;
    private String salesStatus;
    private Date salesDate;
    private String itemId;
    private int quantity;
    private BigDecimal price;
}