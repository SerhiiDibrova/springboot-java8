

package hello.service;

import hello.repository.Table7Repository;
import hello.service.Proc7Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Trigger7Service {
    private final Proc7Service proc7Service;
    private final Table7Repository table7Repository;

    @Autowired
    public Trigger7Service(Proc7Service proc7Service, Table7Repository table7Repository) {
        this.proc7Service = proc7Service;
        this.table7Repository = table7Repository;
    }

    public void trigger7(Table7 table7) {
        Long id = table7.getId();
        proc7Service.executeProc7(id);
    }
}