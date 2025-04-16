

package hello.service.impl;

import hello.entity.NameEntity;
import hello.repository.NameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NameServiceImpl implements NameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NameServiceImpl.class);

    @Autowired
    private NameRepository nameRepository;

    @Override
    public void insertName(Integer id) {
        if (id == null) {
            LOGGER.error("Id cannot be null");
            throw new IllegalArgumentException("Id cannot be null");
        }

        try {
            String name = nameRepository.getNameById(id);
            if (name == null) {
                LOGGER.error("Name not found for id: {}", id);
                throw new RuntimeException("Name not found for id: " + id);
            }

            NameEntity nameEntity = new NameEntity();
            nameEntity.setId(id);
            nameEntity.setName(name);
            nameEntity.setCreatedAt(LocalDateTime.now()));
            nameRepository.insert(nameEntity);
        } catch (Exception e) {
            LOGGER.error("Error inserting name", e);
            throw new RuntimeException("Error inserting name", e);
        }
    }
}