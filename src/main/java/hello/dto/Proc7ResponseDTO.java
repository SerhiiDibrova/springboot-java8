

package hello.dto;

import javax.validation.constraints.NotNull;

public class Proc7ResponseDTO {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}