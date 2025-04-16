

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.TableName;

public interface TableNameRepository extends JpaRepository<TableName, Long> {
}