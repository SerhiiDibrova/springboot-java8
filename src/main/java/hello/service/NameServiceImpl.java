

package hello.service;

import hello.entity.Name;
import hello.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class NameServiceImpl {

    @Autowired
    private NameRepository nameRepository;

    public void proc26(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid id");
        }
        String name = nameRepository.getNameById(id);
        if (name == null) {
            throw new RuntimeException("Name not found for id " + id);
        }
        Name newName = new Name(name);
        newName.setCreatedAt(LocalDateTime.now());
        if (!isValidName(newName)) {
            throw new RuntimeException("Invalid name");
        }
        try {
            nameRepository.save(newName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save name", e);
        }
    }

    private boolean isValidName(Name name) {
        // implement name validation logic here
        return true;
    }
}