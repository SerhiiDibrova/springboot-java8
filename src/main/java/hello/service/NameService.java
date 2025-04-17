

package hello.service;

import hello.repository.NameRepository;
import hello.function.Func5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NameService.class);

    @Autowired
    private NameRepository nameRepository;

    @Autowired
    private Func5 func5;

    public String getNameById(Integer id) {
        NameEntity nameEntity = nameRepository.findByNameId(id);
        if (nameEntity != null) {
            return nameEntity.getName();
        } else {
            LOGGER.error("NameEntity not found for id: {}", id);
            return null;
        }
    }

    @Transactional
    public void insertName(Integer input) {
        if (input != null) {
            try {
                String value = func5.func_5(input);
                nameRepository.insertName(value);
            } catch (Exception e) {
                LOGGER.error("Error inserting name", e);
            }
        } else {
            LOGGER.error("Input is null or empty");
        }
    }
}