

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class NameRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Query("SELECT n.name FROM Name n WHERE n.id = :id")
    public String getNameById(@Param("id") int id) {
        return entityManager.createQuery("SELECT n.name FROM Name n WHERE n.id = :id")
                .setParameter("id", id)
                .getSingleResult()
                .toString();
    }
}