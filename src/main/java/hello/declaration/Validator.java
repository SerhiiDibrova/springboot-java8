package hello.declaration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Validator {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Validate {
        String fieldName();
        boolean required() default false;
    }

    public void validate(String fieldName, boolean required) throws Exception {
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Validate.class)) {
                Validate validate = method.getAnnotation(Validate.class);
                if (validate.fieldName().equals(fieldName) && validate.required() == required) {
                    method.invoke(this);
                }
            }
        }
    }

    @Validate(fieldName = "total", required = true)
    public void compute_total() {
        // Validation logic for compute_total
    }
}