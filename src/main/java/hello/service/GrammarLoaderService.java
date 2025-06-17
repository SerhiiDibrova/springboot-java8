package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.utils.SourceRoot;
import hello.repository.GrammarLoaderRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Configuration
@EnableJpaRepositories(basePackages = "hello.repository")
@EntityScan(basePackages = "hello.model")
@PropertySource("classpath:application.properties")
public class GrammarLoaderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GrammarLoaderService.class);
    private final GrammarLoaderRepository grammarLoaderRepository;
    private JavaParser parser;

    @Autowired
    public GrammarLoaderService(GrammarLoaderRepository grammarLoaderRepository) {
        this.grammarLoaderRepository = grammarLoaderRepository;
        this.parser = new JavaParser();
    }

    public boolean loadGrammar() {
        try {
            grammarLoaderRepository.loadGrammar();
            return true;
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found exception occurred while loading grammar", e);
            return false;
        } catch (Exception e) {
            LOGGER.error("An error occurred while loading grammar", e);
            return false;
        }
    }

    public void loadCppGrammar() {
        try {
            File file = new File("path_to_grammar_file");
            CompilationUnit cu = parser.parse(file).getResult().get();
            cu.accept(new VoidVisitorAdapter<Void>() {
                @Override
                public void visit(ClassOrInterfaceDeclaration n, Void arg) {
                    LOGGER.info("Loading class or interface declaration");
                    super.visit(n, arg);
                }

                @Override
                public void visit(MethodDeclaration n, Void arg) {
                    LOGGER.info("Loading method declaration");
                    super.visit(n, arg);
                }
            }, null);
        } catch (Exception e) {
            LOGGER.error("An error occurred while loading C++ grammar", e);
        }
    }
}