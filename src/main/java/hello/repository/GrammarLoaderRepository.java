package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.entity.Grammar;

public interface GrammarLoaderRepository extends JpaRepository<Grammar, Long> {

    @Query("SELECT g FROM Grammar g")
    Grammar loadGrammar(@Param("id") Long id);
}