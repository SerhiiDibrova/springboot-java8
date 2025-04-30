package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ManagerDTO implements Serializable {
    @NotNull
    @JsonProperty("managerId")
    private Integer managerId;

    public ManagerDTO(Integer managerId) {
        if (managerId == null) {
            throw new IllegalArgumentException("managerId cannot be null");
        }
        this.managerId = managerId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        if (managerId == null) {
            throw new IllegalArgumentException("managerId cannot be null");
        }
        this.managerId = managerId;
    }
}