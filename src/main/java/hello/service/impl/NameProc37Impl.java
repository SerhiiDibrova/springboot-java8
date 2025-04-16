

package hello.service.impl;

import hello.entity.NameEntity;
import hello.repository.NameRepository;
import hello.service.NameService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class NameProc37Impl {

    private final NameService nameService;
    private final NameRepository nameRepository;

    public NameProc37Impl(NameService nameService, NameRepository nameRepository) {
        this.nameService = nameService;
        this.nameRepository = nameRepository;
    }

    public void processNameById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        try {
            String name = nameService.getNameById(id);
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
            NameEntity nameEntity = new NameEntity();
            nameEntity.setName(name);
            nameEntity.setCreatedAt(LocalDateTime.now());
            // Set any other required fields of the NameEntity object
            nameRepository.save(nameEntity);
        } catch (Exception e) {
            // Handle any potential exceptions
            throw new RuntimeException(e);
        }
    }
}