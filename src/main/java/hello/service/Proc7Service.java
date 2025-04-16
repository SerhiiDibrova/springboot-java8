

package hello.service;

import hello.entity.Table7;
import hello.repository.Table7Repository;
import hello.service.Func7Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class Proc7Service {

    @Autowired
    private Func7Service func7Service;

    @Autowired
    private Table7Repository table7Repository;

    public void proc7(int id) {
        String result = func7Service.func7(id);
        Table7 table7 = new Table7();
        table7.setId(id);
        table7.setName(result);
        table7.setCreatedAt(LocalDateTime.now());
        table7Repository.save(table7);
    }
}