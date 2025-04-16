

package hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Trigger8Config {

    @Bean
    public Trigger8Service trigger8Service() {
        return new Trigger8Service();
    }
}