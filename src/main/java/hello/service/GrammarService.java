package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.GrammarRepository;
import com.github.vangj.bonnie.parser.Grammar;
import com.github.vangj.bonnie.parser.Parser;
import com.github.vangj.bonnie.parser.ParserException;

@Service
public class GrammarService {

    private final GrammarRepository grammarRepository;

    @Autowired
    public GrammarService(GrammarRepository grammarRepository) {
        this.grammarRepository = grammarRepository;
    }

    public Grammar loadGrammar() {
        String grammarData = grammarRepository.loadGrammarData();
        Parser parser = new Parser();
        try {
            return parser.parse(grammarData);
        } catch (ParserException e) {
            throw new RuntimeException("Failed to parse grammar data", e);
        }
    }

    public void validateGrammar(Grammar grammar) {
        Parser parser = new Parser();
        try {
            parser.validate(grammar);
        } catch (ParserException e) {
            throw new RuntimeException("Failed to validate grammar", e);
        }
    }

    public void saveGrammar(Grammar grammar) {
        String grammarData = grammar.toString();
        grammarRepository.saveGrammarData(grammarData);
    }
}