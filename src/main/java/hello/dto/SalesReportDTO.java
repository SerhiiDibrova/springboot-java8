package hello.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class SalesReportDTO {
    private String orderIdentifier;
    private String customerFullName;
    private String salesStatus;
    private LocalDate orderDate;
}