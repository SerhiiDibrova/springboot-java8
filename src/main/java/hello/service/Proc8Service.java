

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.model.Table8;
import hello.repository.Table8Repository;
import hello.service.NameRetrievalService;

@Service
public class Proc8Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc8Service.class);

    @Autowired
    private NameRetrievalService nameRetrievalService;

    @Autowired
    private Table8Repository table8Repository;

    public void executeProc8(int id) {
        if (id <= 0) {
            LOGGER.error("Invalid input ID: {}", id);
            throw new IllegalArgumentException("Invalid input ID");
        }

        try {
            String name = nameRetrievalService.getName(id);
            Table8 table8 = new Table8(id, name);
            table8Repository.save(table8);
        } catch (Exception e) {
            LOGGER.error("Error executing proc_8 procedure", e);
            throw new RuntimeException("Error executing proc_8 procedure", e);
        }
    }
}