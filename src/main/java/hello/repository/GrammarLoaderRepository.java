package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hello.entity.Grammar;
import hello.exception.GrammarLoadingException;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import hello.antlr.CPP14Lexer;
import hello.antlr.CPP14Parser;

@Repository
public interface GrammarLoaderRepository extends JpaRepository<Grammar, Long> {

    @Transactional
    default boolean loadGrammar() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("cpp14.g4")) {
            CPP14Lexer lexer = new CPP14Lexer(CharStreams.fromStream(inputStream));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CPP14Parser parser = new CPP14Parser(tokens);
            ParseTree tree = parser.translationunit();
            Grammar grammar = new Grammar();
            grammar.setLoaded(true);
            save(grammar);
            return true;
        } catch (IOException e) {
            throw new GrammarLoadingException("Failed to load grammar", e);
        }
    }
}