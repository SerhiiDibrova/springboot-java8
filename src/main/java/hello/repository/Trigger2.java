

package hello.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface Trigger2 {
    void executeTrigger(Integer id);
}