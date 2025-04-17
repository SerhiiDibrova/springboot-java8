

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import hello.entity.Table5Entity;
import hello.repository.Table5Repository;

@Service
public class Proc45Service {

    @Autowired
    private Table5Repository table5Repository;

    public void proc45(int inputParam) {
        try {
            String stringValue = dbo.func_5(inputParam);
            Table5Entity entity = new Table5Entity(stringValue, new Date());
            table5Repository.save(entity);
        } catch (Exception e) {
            // handle exception
        }
    }
}