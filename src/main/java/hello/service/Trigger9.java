

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Trigger9 {

    private final Table9Repository table9Repository;
    private final Proc9Service proc9Service;

    @Autowired
    public Trigger9(Table9Repository table9Repository, Proc9Service proc9Service) {
        this.table9Repository = table9Repository;
        this.proc9Service = proc9Service;
    }

    public void trigger9(Table9 table9) {
        if (table9 != null) {
            try {
                Table9 savedTable9 = table9Repository.save(table9);
                Long id = savedTable9.getId();
                if (id != null) {
                    try {
                        proc9Service.execute(id);
                    } catch (Exception e) {
                        // handle exception
                    }
                } else {
                    // handle null id
                }
            } catch (Exception e) {
                // handle exception
            }
        } else {
            // handle null table9
        }
    }
}