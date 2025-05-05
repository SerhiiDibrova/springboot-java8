package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TempItemsRepository extends CrudRepository<TempItems, Long> {
    void createTempItems();
    List<DisplayOptionsDTO> retrieveDisplayOptions();
}