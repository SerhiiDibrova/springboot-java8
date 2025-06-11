package hello.repository;

import org_treesitter.TSParser;
import org_treesitter.TSLanguage;
import java.util.logging.Logger;

public class TreeSitterGrammarLoader {
    private static final String GRAMMAR_FILE_PATH = "path_to_grammar_file";
    private static final Logger LOGGER = Logger.getLogger(TreeSitterGrammarLoader.class.getName());
    private TSParser parser;
    private TSLanguage language;

    public boolean loadGrammar() {
        try {
            language = TSLanguage.load(GRAMMAR_FILE_PATH);
            if (language == null) {
                LOGGER.severe("Failed to load language");
                return false;
            }
            parser = new TSParser();
            if (parser == null) {
                LOGGER.severe("Failed to create parser");
                return false;
            }
            parser.setLanguage(language);
            return true;
        } catch (Exception e) {
            LOGGER.severe("Error loading grammar: " + e.getMessage());
            return false;
        }
    }
}