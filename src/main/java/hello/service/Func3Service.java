

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.repository.Table3Repository;

@Service
public class Func3Service {

    @Autowired
    private Table3Repository table3Repository;

    public String getName(Integer id) {
        try {
            String name = table3Repository.getName(id);
            name = dbo.func_3(id);
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void execute(Integer input) {
        try {
            String name = dbo.func_3(input);
            // Implement the logic to generate the name based on the input parameter
            // For example:
            // table3Repository.saveName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}