

package hello.service;

import hello.dto.InputDTO;
import hello.repository.Table0Repository;
import java.time.LocalDateTime;
import java.util.Objects;

public class Proc40Service {
    private Table0Repository table0Repository;

    public Proc40Service(Table0Repository table0Repository) {
        this.table0Repository = table0Repository;
    }

    public void execute(InputDTO inputDTO) {
        if (Objects.isNull(inputDTO)) {
            throw new NullPointerException("InputDTO cannot be null");
        }
        try {
            Table0 table0 = new Table0();
            table0.setName(func_0(inputDTO));
            table0.setCreatedAt(LocalDateTime.now());
            table0Repository.save(table0);
        } catch (Exception e) {
            throw new RuntimeException("Error executing Proc40Service", e);
        }
    }

    private String func_0(InputDTO inputDTO) {
        // implement func_0 logic
        // for demonstration purposes, a simple concatenation of inputDTO fields is used
        return inputDTO.getField1() + inputDTO.getField2();
    }
}