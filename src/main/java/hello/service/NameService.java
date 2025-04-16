

package hello.service;

import hello.model.Name;
import hello.model.NameEntity;
import hello.repository.NameRepository;
import hello.service.NameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NameService {

    @Autowired
    private NameRepository nameRepository;

    @Autowired
    private NameGenerator nameGenerator;

    @PersistenceContext
    private EntityManager entityManager;

    public String getNameById(Integer id) {
        return nameRepository.getNameById(id);
    }

    public void insertName(Integer id) {
        String name = nameRepository.getNameById(id);
        NameEntity nameEntity = new NameEntity(id, name);
        nameRepository.save(nameEntity);
    }

    public void proc_23(Integer id) {
        String name = func_3(id);
        NameEntity nameEntity = new NameEntity();
        nameEntity.setId(id);
        nameEntity.setName(name);
        nameEntity.setCreatedAt(LocalDateTime.now());
        nameRepository.save(nameEntity);
    }

    public String proc27(Integer id) {
        String name = getNameById(id);
        NameEntity nameEntity = new NameEntity(id, name, LocalDateTime.now());
        nameEntity.setCreatedAt(LocalDateTime.now());
        nameRepository.save(nameEntity);
        return name;
    }

    public void proc_41(Integer id) {
        NameEntity nameEntity = nameRepository.findById(id).orElse(new NameEntity());
        nameEntity.setName(func_1(id));
        nameRepository.save(nameEntity);
    }

    public void insertRecord(Integer id) {
        String name = nameGenerator.generateName(id);
        String existingName = getNameById(id);
        if (existingName != null) {
            name = existingName;
        }
        NameEntity nameEntity = new NameEntity(id, name, LocalDateTime.now());
        nameRepository.save(nameEntity);
    }

    private String func_3(Integer id) {
        // Implement func_3 logic here
        return "Name_" + id;
    }

    private String func_1(Integer id) {
        // Implement func_1 logic here
        return "Name_" + id;
    }
}