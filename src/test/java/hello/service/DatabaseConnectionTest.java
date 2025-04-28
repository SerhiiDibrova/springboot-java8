package hello.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseConnectionTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private DatabaseConnection databaseConnection;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        Object[] params = new Object[]{"John", 1};

        databaseConnection.execute(sql, params);

        verify(jdbcTemplate).update(eq(sql), eq(params));
    }
}