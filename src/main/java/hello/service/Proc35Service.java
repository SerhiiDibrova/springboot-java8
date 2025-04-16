

package hello.service;

import hello.entity.Table15;
import hello.repository.Table15Repository;
import hello.service.Func5Service;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proc35Service {

    private final Func5Service func5Service;
    private final Table15Repository table15Repository;
    private static final Logger LOGGER = Logger.getLogger(Proc35Service.class.getName());

    public Proc35Service(Func5Service func5Service, Table15Repository table15Repository) {
        this.func5Service = func5Service;
        this.table15Repository = table15Repository;
    }

    public void proc35(Integer inputParam) {
        if (inputParam == null) {
            LOGGER.log(Level.SEVERE, "Input parameter is null");
            return;
        }
        try {
            String stringValue = func5Service.func5(inputParam);
            Table15 table15 = new Table15();
            table15.setId(inputParam);
            table15.setName(stringValue);
            table15.setCreatedAt(LocalDateTime.now());
            table15Repository.save(table15);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "An error occurred during proc35 execution", ex);
        }
    }
}