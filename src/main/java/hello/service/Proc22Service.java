

package hello.service;

import hello.model.NameEntity;
import hello.repository.NameRepository;
import hello.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Proc22Service {

    private final NameService nameService;
    private final NameRepository nameRepository;

    @Autowired
    public Proc22Service(NameService nameService, NameRepository nameRepository) {
        this.nameService = nameService;
        this.nameRepository = nameRepository;
    }

    public void executeProc22(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer");
        }
        try {
            String name = nameService.getName(input);
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            NameEntity nameEntity = new NameEntity(name);
            nameRepository.save(nameEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error executing proc22", e);
        }
    }
}