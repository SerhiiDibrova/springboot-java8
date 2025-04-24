

package hello.repository;

import hello.model.TempItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public interface TempItemRepository extends CrudRepository<TempItemEntity, Long> {

    void createTempItemTable();

    void insertTempItem(TempItemEntity tempItem);
}