

package hello.model;

import java.lang.Long;
import java.lang.String;

public class Department<T extends Long> {
    private T id;
    private String name;
    private String budget;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        if (id == null) {
            throw new NullPointerException("Id cannot be null");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        if (budget == null || budget.isEmpty()) {
            throw new NullPointerException("Budget cannot be null or empty");
        }
        this.budget = budget;
    }
}