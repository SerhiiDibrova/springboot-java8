

package hello.service;

import hello.repository.Table12Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Service
public class Proc12Service {

    private final Table12Repository table12Repository;

    @Autowired
    public Proc12Service(Table12Repository table12Repository) {
        this.table12Repository = Objects.requireNonNull(table12Repository, "Table12Repository must not be null");
    }

    public void insertRecord(@NotNull Integer input) {
        try {
            table12Repository.insertRecord(input);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting record", e);
        }
    }

    public String getName(@NotNull Integer input) {
        try {
            return table12Repository.func_2(input);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving name", e);
        }
    }
}