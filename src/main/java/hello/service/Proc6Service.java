

package hello.service;

import hello.entity.Proc6Record;
import hello.repository.Proc6Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Proc6Service {

    private final Proc6Repository proc6Repository;

    @Autowired
    public Proc6Service(Proc6Repository proc6Repository) {
        this.proc6Repository = proc6Repository;
    }

    public void proc6(int input) {
        String name = func6(input);
        Proc6Record record = new Proc6Record();
        record.setName(name);
        record.setCreatedDate(LocalDateTime.now());
        proc6Repository.save(record);
    }

    private String func6(int input) {
        // implement func6 logic here
        // for example, let's assume func6 returns "John" for input 1, "Alice" for input 2, etc.
        switch (input) {
            case 1:
                return "John";
            case 2:
                return "Alice";
            default:
                return "Unknown";
        }
    }
}