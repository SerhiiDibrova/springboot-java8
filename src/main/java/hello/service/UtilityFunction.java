package hello.service;

import hello.model.ClassA;
import hello.model.ClassC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class UtilityFunction {

    private final ClassA classA;
    private final ClassC classC;

    @Autowired
    public UtilityFunction(ClassA classA, ClassC classC) {
        if (classA == null || classC == null) {
            throw new NullPointerException("ClassA and ClassC cannot be null");
        }
        this.classA = classA;
        this.classC = classC;
    }

    public Object[] processResults() {
        try {
            Object resultA = classA.methodA();
            Object resultC = classC.methodC();
            return Arrays.asList(resultA, resultC).toArray();
        } catch (Exception e) {
            throw new RuntimeException("Error processing results", e);
        }
    }
}