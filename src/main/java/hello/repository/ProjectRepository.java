

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.Project;

public interface ProjectRepository extends JpaRepository<hello.entity.Project, Long> {
}