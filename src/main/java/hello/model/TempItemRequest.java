package hello.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TempItemRequest {
    @NotNull
    private Integer orderId;

    @NotNull
    private String xmlData;

    public TempItemRequest(@NotNull Integer orderId, @NotNull String xmlData) {
        this.orderId = orderId;
        this.xmlData = xmlData;
    }
}