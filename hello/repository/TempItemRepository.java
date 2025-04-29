package hello.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.model.TempItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TempItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JpaRepository<TempItem, Long> jpaRepository;

    @Transactional
    public TempItem save(TempItem tempItem) {
        return jpaRepository.save(tempItem);
    }

    public TempItem findById(Long id) {
        return jpaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    public List<TempItem> findAll() {
        return jpaRepository.findAll();
    }
}