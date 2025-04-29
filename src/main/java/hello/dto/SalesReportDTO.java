package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class SalesReportDTO {

    @JsonProperty("order_identifier")
    @Size(max = 255)
    private String orderIdentifier;

    @JsonProperty("customer_full_name")
    @Size(max = 255)
    private String customerFullName;

    @JsonProperty("order_date")
    @NotNull
    private Date orderDate;

    @JsonProperty("additional_field_1")
    private String additionalField1;

    @JsonProperty("additional_field_2")
    private Integer additionalField2;
}