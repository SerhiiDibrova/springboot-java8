

package hello.service;

import hello.entity.Table8;
import hello.repository.Table8Repository;
import hello.service.NameRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class Proc38Service {

    private final NameRetrievalService nameRetrievalService;
    private final Table8Repository table8Repository;

    @Autowired
    public Proc38Service(NameRetrievalService nameRetrievalService, Table8Repository table8Repository) {
        this.nameRetrievalService = nameRetrievalService;
        this.table8Repository = table8Repository;
    }

    public Table8 createRecord(String inputParam) {
        Assert.notNull(inputParam, "Input parameter must not be null");
        String name = nameRetrievalService.retrieveNameById(inputParam);
        Assert.notNull(name, "Name must not be null");
        Table8 table8 = new Table8();
        table8.setName(name);
        table8.setCreatedAt(new Timestamp(new Date().getTime()));
        return table8Repository.save(table8);
    }
}