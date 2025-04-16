

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hello.service.Proc5Service;
import hello.model.Table5;

@Component
public class Table5Listener {
    @Autowired
    private Proc5Service proc5Service;

    public void onInsert(Table5 table5) {
        int id = table5.getId();
        proc5Service.proc5(id);
    }
}