package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.entity.Grammar;
import java.util.List;

@Repository
public interface GrammarLoaderRepository extends JpaRepository<Grammar, Long> {

    @Query("SELECT g FROM Grammar g")
    List<Grammar> loadGrammar();

    @Query("SELECT g FROM Grammar g WHERE g.id = :id")
    Grammar loadGrammarById(@Param("id") Long id);

    @Query("SELECT g FROM Grammar g WHERE g.name = :name")
    Grammar loadGrammarByName(@Param("name") String name);
}