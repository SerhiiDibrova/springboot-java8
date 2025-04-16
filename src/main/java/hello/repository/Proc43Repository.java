

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Proc43Repository<T, ID> extends JpaRepository<T, ID> {

}