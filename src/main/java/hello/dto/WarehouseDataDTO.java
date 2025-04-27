package hello.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDataDTO {
    @NotNull
    private Long id;
    
    @NotNull
    private String name;
    
    @NotNull
    private String location;
    
    @NotNull
    private Integer capacity;
    
    @NotNull
    private String manager;
}