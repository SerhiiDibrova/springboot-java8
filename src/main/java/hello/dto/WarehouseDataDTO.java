package hello.dto;

import lombok.Data;

@Data
public class WarehouseDataDTO {
    private Long id;
    private String name;
    private String location;
    private Integer capacity;
    private String manager;
}