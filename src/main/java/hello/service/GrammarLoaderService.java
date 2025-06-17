package hello.service;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

import hello.antlr.CPP14Lexer;
import hello.antlr.CPP14Parser;

import java.util.logging.Logger;

@Service
public class GrammarLoaderService {

    private static final Logger LOGGER = Logger.getLogger(GrammarLoaderService.class.getName());

    public boolean loadGrammar(String grammar) {
        if (grammar == null || grammar.isEmpty()) {
            LOGGER.severe("Input grammar is null or empty");
            return false;
        }

        try {
            CPP14Lexer lexer = new CPP14Lexer(CharStreams.fromString(grammar));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CPP14Parser parser = new CPP14Parser(tokens);
            ParseTree tree = parser.translationunit();
            return true;
        } catch (org.antlr.v4.runtime.RecognitionException e) {
            LOGGER.severe("Error parsing grammar: " + e.getMessage());
            return false;
        } catch (Exception e) {
            LOGGER.severe("An error occurred while loading grammar: " + e.getMessage());
            return false;
        }
    }
}