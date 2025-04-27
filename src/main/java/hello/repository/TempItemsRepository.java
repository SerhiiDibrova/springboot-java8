package hello.repository;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public interface TempItemsRepository {
    void createTempItemsTable();
}

@Repository
class TempItemsRepositoryImpl implements TempItemsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TempItemsRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createTempItemsTable() {
        String sql = "CREATE TABLE #TempItems (Id INT, Name VARCHAR(255))";
        jdbcTemplate.execute(sql);
    }
}