package hello.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "table_a")
public class A {

    @Id
    @GeneratedValue
    private Long id;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String methodA() {
        return "Result from methodA in entity A with value: " + value;
    }

    public String methodC() {
        try {
            return "Result from methodC in entity A with value: " + value;
        } catch (Exception e) {
            throw new RuntimeException("Error in methodC: " + e.getMessage());
        }
    }
}