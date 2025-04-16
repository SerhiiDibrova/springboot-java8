

package hello.service;

import hello.repository.Proc17Repository;
import hello.entity.Proc17Entity;
import hello.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class Proc17Service {

    @Autowired
    private Proc17Repository proc17Repository;

    @Autowired
    private NameService nameService;

    public void proc17(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input parameter cannot be null");
        }
        if (proc17Repository == null) {
            throw new IllegalStateException("Proc17Repository is not initialized");
        }
        if (nameService == null) {
            throw new IllegalStateException("NameService is not initialized");
        }
        try {
            String result = nameService.func7(input);
            Proc17Entity proc17Entity = new Proc17Entity();
            proc17Entity.setDate(LocalDateTime.now());
            proc17Entity.setResult(result);
            proc17Entity.setInput(input);
            proc17Repository.save(proc17Entity);
        } catch (Exception e) {
            throw new RuntimeException("Error executing proc17 procedure", e);
        }
    }
}