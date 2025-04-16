

package hello.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlParameterSource;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import hello.service.NameService;
import hello.repository.Trigger2;

@Repository
public class Trigger2Impl implements Trigger2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NameService nameService;

    @Override
    public void executeTrigger(Integer id) {
        String name = nameService.getName(id);
        jdbcTemplate.update("call proc_2(?)", name);
    }
}