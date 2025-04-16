

package hello.repository;

import hello.model.Table10Record;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Table10Repository {

    private final JdbcTemplate jdbcTemplate;

    public Table10Repository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(Table10Record record) {
        String sql = "INSERT INTO table_10 (column1, column2, column3) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, record.getColumn1(), record.getColumn2(), record.getColumn3());
    }
}