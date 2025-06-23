package hello.model;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Component
@Entity
public class C {

    @Id
    private String id = UUID.randomUUID().toString();

    public String method_c() {
        return "Method C executed";
    }

    public static class UtilityFunction {
        private final C c;

        public UtilityFunction(C c) {
            this.c = c;
        }

        public String utilityFunction() {
            return c.method_c();
        }
    }
}