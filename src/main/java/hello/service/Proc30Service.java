

package hello.service;

import hello.model.Table10;
import hello.repository.Table10Repository;
import hello.util.Func0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class Proc30Service {

    @Autowired
    private Table10Repository table10Repository;

    @Autowired
    private Func0 func0;

    public Table10 insertRecord(Integer input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        Table10 table10 = new Table10();
        table10.setName(func0.generateName());
        table10.setTimestamp(LocalDateTime.now());
        table10.setInput(input);
        return table10Repository.save(table10);
    }
}