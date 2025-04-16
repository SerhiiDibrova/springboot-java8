

package hello.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Proc4Service {

    private final JdbcTemplate jdbcTemplate;

    public Proc4Service(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertRecord(int id) {
        try {
            Table4 table4 = new Table4();
            table4.setId(id);
            table4.setName(func4(id));
            table4.setCreatedAt(LocalDateTime.now());

            String sql = "INSERT INTO table_4 (id, name, created_at) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, table4.getId(), table4.getName(), table4.getCreatedAt());
        } catch (Exception e) {
            // handle exception
        }
    }

    private String func4(int id) {
        // implement func4 logic here
        return "name_" + id;
    }

    private static class Table4 {
        private int id;
        private String name;
        private LocalDateTime createdAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }
}