package hello.dto;

public class ManagerIdDTO {
    private Integer managerId;

    public ManagerIdDTO(Integer managerId) {
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