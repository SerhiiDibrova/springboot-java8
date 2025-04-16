

package hello.service;

import hello.model.Table18;
import hello.service.NameRetrievalService;
import java.time.LocalDateTime;
import java.util.UUID;

public class TableCreationService {

    private final NameRetrievalService nameRetrievalService;
    private final Table18Repository table18Repository;

    public TableCreationService(NameRetrievalService nameRetrievalService, Table18Repository table18Repository) {
        this.nameRetrievalService = nameRetrievalService;
        this.table18Repository = table18Repository;
    }

    public void createTable18(UUID input) {
        String name = nameRetrievalService.retrieveNameById(input);
        Table18 table18 = new Table18(input, name, LocalDateTime.now());
        table18Repository.save(table18);
    }
}