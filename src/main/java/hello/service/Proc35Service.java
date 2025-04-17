

package hello.service;

import hello.entity.Table15Entity;
import hello.repository.Table15Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.logging.Logger;

@Service
public class Proc35Service {

    private final Table15Repository table15Repository;
    private final RestTemplate restTemplate;
    private final String func5Url;
    private final Logger logger;

    @Autowired
    public Proc35Service(Table15Repository table15Repository, RestTemplate restTemplate, @Value("${func5.url}") String func5Url) {
        this.table15Repository = table15Repository;
        this.restTemplate = restTemplate;
        this.func5Url = func5Url;
        this.logger = Logger.getLogger(Proc35Service.class.getName());
    }

    @Transactional
    public void createRecord(Integer input) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(func5Url, String.class);
            if (response.getStatusCode() != HttpStatus.OK) {
                logger.severe("Failed to retrieve string value from func_5. Status code: " + response.getStatusCode());
                throw new RuntimeException("Failed to retrieve string value from func_5");
            }
            String stringValue = response.getBody();
            @Valid Table15Entity entity = new Table15Entity(stringValue, input);
            table15Repository.save(entity);
        } catch (Exception e) {
            logger.severe("Error creating record: " + e.getMessage());
            throw new RuntimeException("Error creating record", e);
        }
    }
}