package hello.declaration;

import org.springframework.stereotype.Component;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Component
public class Validator {

    public Decorator validator(String fieldName, boolean... always) {
        return new Decorator(fieldName, always.length > 0 ? always[0] : false);
    }

    public static class Decorator {
        private String fieldName;
        private boolean always;

        public Decorator(String fieldName, boolean always) {
            if (fieldName == null || fieldName.isEmpty()) {
                throw new IllegalArgumentException("fieldName cannot be null or empty");
            }
            this.fieldName = fieldName;
            this.always = always;
        }

        public void validate(Object target, Method method, Object[] args) throws Exception {
            if (always || (args.length > 0 && args[0] == null)) {
                throw new IllegalArgumentException(fieldName + " cannot be null");
            }
        }
    }
}