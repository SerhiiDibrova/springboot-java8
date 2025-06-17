package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.io.InputStream;

import com.github.javassist.ClassPool;
import com.github.javassist.CtClass;
import com.github.javassist.CtMethod;
import com.github.javassist.Javassist;

import org.tree_sitter.TreeSitter;
import org.tree_sitter.TreeSitterParser;
import org.tree_sitter.TreeSitterLanguage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class GrammarLoaderService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public boolean loadGrammar() {
        try {
            TreeSitterParser parser = new TreeSitterParser();
            TreeSitterLanguage language = TreeSitterLanguage.load("cpp");
            parser.setLanguage(language);
            InputStream in = getClass().getResourceAsStream("/grammar.txt");
            byte[] grammarBytes = in.readAllBytes();
            parser.parse(grammarBytes, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}