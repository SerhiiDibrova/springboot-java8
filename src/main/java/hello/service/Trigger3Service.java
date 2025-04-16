

package hello.service;

import hello.model.Table3;
import hello.service.Proc3Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Trigger3Service {

    private final Proc3Service proc3Service;
    private final JdbcTemplate jdbcTemplate;

    public Trigger3Service(Proc3Service proc3Service, JdbcTemplate jdbcTemplate) {
        this.proc3Service = proc3Service;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void trigger3() {
        int id = retrieveId();
        proc3Service.proc3(id);
    }

    private int retrieveId() {
        return jdbcTemplate.queryForObject("SELECT id FROM inserted", Integer.class);
    }
}