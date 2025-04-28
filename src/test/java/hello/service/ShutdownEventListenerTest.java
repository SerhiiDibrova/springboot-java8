package hello.service;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ShutdownEventListenerTest {

    @InjectMocks
    private ShutdownEventListener shutdownEventListener;

    @Mock
    private DatabaseConnectionService databaseConnectionService;

    private Logger logger = LoggerFactory.getLogger(ShutdownEventListener.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShutdownEventClosesConnection() {
        shutdownEventListener.shutdownEvent();
        verify(databaseConnectionService, times(1)).closeConnection();
    }

    @Test
    void testShutdownEventLogsErrorOnException() {
        doThrow(new RuntimeException("Connection close error")).when(databaseConnectionService).closeConnection();
        shutdownEventListener.shutdownEvent();
        verify(logger).error(eq("Error closing database connection"), any(RuntimeException.class));
    }
}