

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import hello.repository.Table10Repository;

@Service
public class Proc10Service {

    @Autowired
    private Table10Repository table10Repository;

    public void proc10(int input) {
        try {
            String name = func_0();
            table10Repository.insert(new Table10(input, name, LocalDateTime.now()));
        } catch (Exception e) {
            // handle exception
        }
    }

    private String func_0() {
        // implement func_0 logic here
        return "name";
    }
}