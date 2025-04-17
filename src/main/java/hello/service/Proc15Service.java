

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.repository.Table15Repository;
import hello.service.NameService;

@Service
public class Proc15Service {

    private final Table15Repository table15Repository;
    private final NameService nameService;

    @Autowired
    public Proc15Service(Table15Repository table15Repository, NameService nameService) {
        this.table15Repository = table15Repository;
        this.nameService = nameService;
    }

    public void insertRecord(Integer input) {
        String name = nameService.getName(input);
        table15Repository.insert(name, input);
    }
}