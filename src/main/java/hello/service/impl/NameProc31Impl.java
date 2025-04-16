

package hello.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import hello.service.NameService;
import hello.repository.NameRepository;
import hello.entity.NameEntity;

@Service
public class NameProc31Impl {

    private final NameService nameService;
    private final NameRepository nameRepository;

    @Autowired
    public NameProc31Impl(NameService nameService, NameRepository nameRepository) {
        this.nameService = nameService;
        this.nameRepository = nameRepository;
    }

    public NameEntity execute(int id) {
        try {
            String name = nameService.getName(id);
            NameEntity nameEntity = new NameEntity(id, name);
            return nameRepository.save(nameEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error executing proc_31 procedure", e);
        }
    }
}