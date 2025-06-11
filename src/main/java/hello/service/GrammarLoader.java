package hello.service;

import com.github.vacxe.tree_sitter.TreeSitterGrammarLoader;

public class GrammarLoader {
    public boolean loadGrammar() {
        try {
            TreeSitterGrammarLoader.loadGrammar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}