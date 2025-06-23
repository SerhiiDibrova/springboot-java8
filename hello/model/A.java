package hello.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hello.utility.UtilityFunction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Component
public class A {

    @Id
    private int id;

    @NotNull
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String method_a() {
        return "Method A";
    }

    @Autowired
    private UtilityFunction utilityFunction;

    public void callUtilityFunction() {
        utilityFunction.utilityFunction(this);
    }
}