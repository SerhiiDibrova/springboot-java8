

package hello.service.impl;

import hello.repository.NameRepository;
import hello.service.NameProc12;
import hello.service.NameService;
import hello.entity.NameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class NameProc12Impl implements NameProc12 {

    private static final Logger LOGGER = Logger.getLogger(NameProc12Impl.class.getName());

    @Autowired
    private NameService nameService;

    @Autowired
    private NameRepository nameRepository;

    @Override
    public void processName(Long id) {
        String name = nameService.getNameById(id);
        if (name != null) {
            NameEntity nameEntity = new NameEntity();
            nameEntity.setName(name);
            nameEntity.setCreatedAt(LocalDateTime.now());
            try {
                nameRepository.save(nameEntity);
            } catch (Exception e) {
                LOGGER.severe("Error saving name entity: " + e.getMessage());
            }
        } else {
            LOGGER.warning("Name not found for id: " + id);
        }
    }
}