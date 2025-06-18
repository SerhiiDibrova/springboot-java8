package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.Grammar;

public interface GrammarRepository extends JpaRepository<Grammar, Long> {

    Iterable<Grammar> findAll();

    Grammar findById(Long id);
}