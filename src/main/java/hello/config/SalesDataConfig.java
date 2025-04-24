

package hello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;

import javax.sql.DataSource;
import javax.validation.constraints.NotBlank;

@Configuration
@Validated
public class SalesDataConfig {

    @Value("${database.url}")
    @NotBlank
    private String databaseUrl;

    @Value("${database.username}")
    @NotBlank
    private String databaseUsername;

    @Value("${database.password}")
    @NotBlank
    private String databasePassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}