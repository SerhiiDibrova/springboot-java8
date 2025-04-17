

package hello.trigger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Trigger0 {

    private Table0Service table0Service;

    @Autowired
    public void setTable0Service(Table0Service table0Service) {
        this.table0Service = table0Service;
    }

    public void executeTrigger(Integer id) {
        table0Service.insertRecord(id);
    }
}