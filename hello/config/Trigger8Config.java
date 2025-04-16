

package hello.config;

import org.springframework.context.annotation.Configuration;
import hello.service.Trigger8Service;

@Configuration
public class Trigger8Config {

    public static final String STORED_PROCEDURE_NAME = "proc_8";
    public static final String PARAMETER_NAME = "id";
}