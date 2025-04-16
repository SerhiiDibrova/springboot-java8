

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Proc10Service {

    private final Proc10Repository proc10Repository;
    private final NameService nameService;

    @Autowired
    public Proc10Service(Proc10Repository proc10Repository, NameService nameService) {
        this.proc10Repository = proc10Repository;
        this.nameService = nameService;
    }

    public void proc10(int input) {
        String name = nameService.generateName(input);
        proc10Repository.insertRecord(name);
    }
}