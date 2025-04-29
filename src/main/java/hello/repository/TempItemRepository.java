package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.model.TempItem;
import java.util.Optional;

@Repository
public class TempItemRepositoryImpl implements TempItemRepository {

    private final JpaRepository<TempItem, Long> jpaRepository;

    public TempItemRepositoryImpl(JpaRepository<TempItem, Long> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<TempItem> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public TempItem save(TempItem tempItem) {
        return jpaRepository.save(tempItem);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<TempItem> findAll() {
        return jpaRepository.findAll();
    }
}