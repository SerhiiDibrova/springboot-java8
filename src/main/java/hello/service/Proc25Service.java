

package hello.service;

import hello.entity.Table5;
import hello.repository.Table5Repository;
import hello.service.Func5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Proc25Service {

    private final Func5Service func5Service;
    private final Table5Repository table5Repository;

    @Autowired
    public Proc25Service(Func5Service func5Service, Table5Repository table5Repository) {
        this.func5Service = func5Service;
        this.table5Repository = table5Repository;
    }

    public void proc25(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        try {
            String result = func5Service.func5(input);
            Table5 table5 = new Table5();
            table5.setId(input);
            table5.setName(result);
            table5Repository.save(table5);
        } catch (Exception e) {
            throw new RuntimeException("Error processing input", e);
        }
    }
}